package com.freedasd.rickandmorty.presentation.characterList

import androidx.lifecycle.*
import com.freedasd.rickandmorty.domain.Interactor
import com.freedasd.rickandmorty.presentation.CharacterListRender
import com.freedasd.rickandmorty.presentation.mappers.BaseCharacterListDomainToUiMapper
import com.freedasd.rickandmorty.presentation.modules.CharacterListUi
import com.freedasd.rickandmorty.presentation.modules.CharacterUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    private val interactor: Interactor,
    private val characterListDomainToUiMapper: BaseCharacterListDomainToUiMapper,
    private val render: CharacterListRender,
) : ViewModel() {

    fun fetchCharacterList(page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
           interactor.fetchCharactersList(page).map(characterListDomainToUiMapper).map(render)
        }
    }

    fun observeCharacterList(owner: LifecycleOwner, observer: Observer<List<CharacterUi>>) {
        render.observeCharacterListLiveData(owner, observer)
    }
}