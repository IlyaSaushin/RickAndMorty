package com.freedasd.rickandmorty.data.mappers

import com.freedasd.rickandmorty.data.modules.CharacterData
import com.freedasd.rickandmorty.domain.modules.CharactersListDomain

interface CharacterListDataToDomainMapper {

    fun mapSuccess(list: List<CharacterData>) : CharactersListDomain

    fun mapFail(ex: Exception) : CharactersListDomain
}