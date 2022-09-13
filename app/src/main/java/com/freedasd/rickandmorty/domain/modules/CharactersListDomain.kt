package com.freedasd.rickandmorty.domain.modules

import com.freedasd.rickandmorty.domain.mappers.CharacterListDomainToUiMapper
import com.freedasd.rickandmorty.presentation.modules.CharacterListUi
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Exception

sealed class CharactersListDomain() {

    abstract fun map(mapper: CharacterListDomainToUiMapper): CharacterListUi

    data class Success(private val list: List<CharacterDomain>) : CharactersListDomain() {
        override fun map(mapper: CharacterListDomainToUiMapper) = mapper.mapSuccess(list)
    }

    data class Fail(private val exception: Exception) : CharactersListDomain() {
        override fun map(mapper: CharacterListDomainToUiMapper) = mapper.mapFail(exception)
    }
}