package com.freedasd.rickandmorty.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.freedasd.rickandmorty.data.mappers.CharacterCloudToDataMapper
import com.freedasd.rickandmorty.data.modules.CharacterData
import com.freedasd.rickandmorty.data.retrofit.Service
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

private const val START_CHARACTERS_LIST_POSITION = 1

class CharacterPagingSource @Inject constructor(
    private val service: Service,
    private val cloudToDataMapper: CharacterCloudToDataMapper
) : PagingSource<Int, CharacterData.Base>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterData.Base> {
        val position = params.key ?: START_CHARACTERS_LIST_POSITION
        return try {
            val response = service.charactersList(position)
            val repos = response.results.map { it.map(cloudToDataMapper) }
            val nextKey = if (repos.isEmpty()) null else position + (params.loadSize / NETWORK_PAGE_SIZE)
            LoadResult.Page(
                data = repos,
                prevKey = if (position == START_CHARACTERS_LIST_POSITION) null else position - 1,
                nextKey = nextKey
            )
        } catch (ex: IOException) {
            return LoadResult.Error(ex)
        } catch (e: HttpException) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CharacterData.Base>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
            state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    companion object {

        const val NETWORK_PAGE_SIZE = 20
    }
}