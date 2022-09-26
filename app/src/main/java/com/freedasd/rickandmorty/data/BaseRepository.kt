package com.freedasd.rickandmorty.data

import android.util.Log
import com.freedasd.rickandmorty.data.mappers.CharacterCloudToDataMapper
import com.freedasd.rickandmorty.data.modules.CharacterData
import com.freedasd.rickandmorty.data.modules.CharacterListData
import com.freedasd.rickandmorty.data.retrofit.Service
import com.freedasd.rickandmorty.domain.Repository
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

class BaseRepository @Inject constructor(
    private val service: Service,
    private val characterCLoudToDataMapper: CharacterCloudToDataMapper
) : Repository {

    override suspend fun fetchCharacterList(page: Int) = try {
        Log.d("tag", "fetchCharacterList: $page")
            val charactersDataList = service.charactersList(page).results.map { it.map(characterCLoudToDataMapper) }
            CharacterListData.Success(charactersDataList)
        } catch (e: Exception) {
            CharacterListData.Fail(e)
        }

    override suspend fun fetchMoreCharactersForRecycler(page: Int) = try {
        val characterPackage = service.charactersList(page).results.map { it.map(characterCLoudToDataMapper) }
        CharacterListData.Success(characterPackage)
    } catch (e: Exception) {
        CharacterListData.Fail(e)
    }
}