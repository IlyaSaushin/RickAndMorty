package com.freedasd.rickandmorty.domain

import androidx.paging.PagingData
import androidx.paging.map
import com.freedasd.rickandmorty.domain.mappers.BaseCharacterDataToDomainMapper
import com.freedasd.rickandmorty.domain.modules.CharacterDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface Interactor {

    fun fetchCharactersList() : Flow<PagingData<CharacterDomain.Base>>

    class Base @Inject constructor(
        private val repository: Repository,
        private val characterDataToDomainMapper: BaseCharacterDataToDomainMapper
    ) : Interactor {

        override fun fetchCharactersList() =
            repository.fetchCharactersList().map { CharacterData ->
                CharacterData.map { it.mapToDomain(characterDataToDomainMapper) }
            }
    }
}