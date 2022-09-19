package com.freedasd.rickandmorty.presentation.modules

import com.freedasd.rickandmorty.domain.modules.CharacterDomain
import com.freedasd.rickandmorty.presentation.CharacterListRender
import com.freedasd.rickandmorty.presentation.mappers.BaseCharacterDomainToUiMapper

sealed class CharacterListUi {

    abstract suspend fun map(render: CharacterListRender)

    data class Success(
        private val list: List<CharacterDomain>,
        private val mapper: BaseCharacterDomainToUiMapper
    ) : CharacterListUi() {
        override suspend fun map(render: CharacterListRender) {
            render.fetchCharacterList(list.map { it.mapToUi(mapper) })
        }
    }

    data class Fail(private val ex: Exception) : CharacterListUi() {
        override suspend fun map(render: CharacterListRender) {

        }
    }
}