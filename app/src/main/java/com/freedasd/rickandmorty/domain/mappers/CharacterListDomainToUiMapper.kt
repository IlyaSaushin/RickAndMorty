package com.freedasd.rickandmorty.domain.mappers

import com.freedasd.rickandmorty.domain.modules.CharacterDomain
import com.freedasd.rickandmorty.presentation.modules.CharacterListUi

interface CharacterListDomainToUiMapper {

    fun mapSuccess(list: List<CharacterDomain>) : CharacterListUi

    fun mapFail(e: Exception) : CharacterListUi
}
