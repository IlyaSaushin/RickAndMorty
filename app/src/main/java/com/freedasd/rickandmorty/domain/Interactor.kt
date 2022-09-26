package com.freedasd.rickandmorty.domain

import com.freedasd.rickandmorty.data.mappers.CharacterListDataToDomainMapper
import com.freedasd.rickandmorty.domain.modules.CharactersListDomain
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

interface Interactor {

    suspend fun fetchCharactersList(page: Int) : CharactersListDomain

    suspend fun fetchMoreCharactersForRecycler(page: Int) : CharactersListDomain

    class Base @Inject constructor(
        private val repository: Repository,
        private val charactersListDataToDomainMapper: CharacterListDataToDomainMapper
    ) : Interactor {

        override suspend fun fetchCharactersList(page: Int) =
            repository.fetchCharacterList(page).map(charactersListDataToDomainMapper)

        override suspend fun fetchMoreCharactersForRecycler(page: Int) =
            repository.fetchMoreCharactersForRecycler(page).map(charactersListDataToDomainMapper)
    }
}