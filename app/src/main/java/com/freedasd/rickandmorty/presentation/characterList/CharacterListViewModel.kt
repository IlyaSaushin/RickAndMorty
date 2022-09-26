package com.freedasd.rickandmorty.presentation.characterList

import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.freedasd.rickandmorty.domain.Interactor
import com.freedasd.rickandmorty.presentation.mappers.BaseCharacterDomainToUiMapper
import com.freedasd.rickandmorty.presentation.modules.CharacterUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    private val interactor: Interactor,
    private val characterDomainToUiMapper: BaseCharacterDomainToUiMapper
) : ViewModel() {

    val charactersFlow : Flow<PagingData<CharacterUi.Base>>

    init {
        charactersFlow = fetchCharactersList()
    }

    private fun fetchCharactersList() =
        interactor.fetchCharactersList().map { CharacterDomain ->
            CharacterDomain.map { it.mapToUi(characterDomainToUiMapper) }
        }.cachedIn(viewModelScope)
}