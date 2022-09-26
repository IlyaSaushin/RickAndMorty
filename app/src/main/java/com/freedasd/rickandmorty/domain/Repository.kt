package com.freedasd.rickandmorty.domain

import com.freedasd.rickandmorty.data.modules.CharacterListData

interface Repository {

    suspend fun fetchCharacterList(page: Int) : CharacterListData

    suspend fun fetchMoreCharactersForRecycler(page: Int) : CharacterListData
}