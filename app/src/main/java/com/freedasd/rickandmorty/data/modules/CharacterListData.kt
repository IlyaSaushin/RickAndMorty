package com.freedasd.rickandmorty.data.modules

import com.freedasd.rickandmorty.data.mappers.CharacterListDataToDomainMapper
import com.freedasd.rickandmorty.domain.modules.CharactersListDomain

sealed class CharacterListData {

    abstract fun map(mapper: CharacterListDataToDomainMapper) : CharactersListDomain

    data class Success(private val list: List<CharacterData>) : CharacterListData() {
        override fun map(mapper: CharacterListDataToDomainMapper) = mapper.mapSuccess(list)
    }

    data class Fail(private val exception: Exception) : CharacterListData() {
        override fun map(mapper: CharacterListDataToDomainMapper) = mapper.mapFail(exception)
    }
}