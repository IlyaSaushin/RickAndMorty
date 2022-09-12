package com.freedasd.rickandmorty.domain

import com.freedasd.rickandmorty.data.mappers.CharacterListDataToDomainMapper
import com.freedasd.rickandmorty.domain.modules.CharactersListDomain

interface Interactor {

    suspend fun fetchCharactersList() : CharactersListDomain

    class Base(
        private val repository: Repository,
        private val charactersListDataToDomainMapper: CharacterListDataToDomainMapper
    ) : Interactor {
        override suspend fun fetchCharactersList() = repository.fetchCharacterList().map(charactersListDataToDomainMapper)
    }
}