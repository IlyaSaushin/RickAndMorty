package com.freedasd.rickandmorty.domain

import androidx.paging.PagingData
import com.freedasd.rickandmorty.data.modules.CharacterData
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun fetchCharactersList() : Flow<PagingData<CharacterData.Base>>
}