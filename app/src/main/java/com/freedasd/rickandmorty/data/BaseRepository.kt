package com.freedasd.rickandmorty.data

import com.freedasd.rickandmorty.data.mappers.CharacterCloudToDataMapper
import com.freedasd.rickandmorty.data.modules.CharacterListData
import com.freedasd.rickandmorty.data.retrofit.Service
import com.freedasd.rickandmorty.domain.Repository

class BaseRepository(
    private val service: Service,
    private val characterCLoudToDataMapper: CharacterCloudToDataMapper
) : Repository {

    override suspend fun fetchCharacterList() = try {
            val charactersDataList = service.charactersList().results.map { it.map(characterCLoudToDataMapper) }
            CharacterListData.Success(charactersDataList)
        } catch (e: Exception) {
            CharacterListData.Fail(e)
        }

}