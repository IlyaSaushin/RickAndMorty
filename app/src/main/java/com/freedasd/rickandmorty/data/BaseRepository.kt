package com.freedasd.rickandmorty.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.freedasd.rickandmorty.data.CharacterPagingSource.Companion.NETWORK_PAGE_SIZE
import com.freedasd.rickandmorty.data.mappers.CharacterCloudToDataMapper
import com.freedasd.rickandmorty.data.modules.CharacterData
import com.freedasd.rickandmorty.data.retrofit.Service
import com.freedasd.rickandmorty.domain.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BaseRepository @Inject constructor(
    private val service: Service,
    private val characterCLoudToDataMapper: CharacterCloudToDataMapper
) : Repository {

    override fun fetchCharactersList(): Flow<PagingData<CharacterData.Base>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { CharacterPagingSource(service, characterCLoudToDataMapper) }
        ).flow
    }
}