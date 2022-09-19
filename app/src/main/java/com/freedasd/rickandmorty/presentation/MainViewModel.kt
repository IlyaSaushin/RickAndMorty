package com.freedasd.rickandmorty.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.freedasd.rickandmorty.data.BaseRepository
import com.freedasd.rickandmorty.data.mappers.CharacterListDataToDomainMapper
import com.freedasd.rickandmorty.data.retrofit.RetrofitClient
import com.freedasd.rickandmorty.domain.Interactor
import com.freedasd.rickandmorty.domain.Repository
import com.freedasd.rickandmorty.presentation.mappers.BaseCharacterListDomainToUiMapper
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val interactor: Interactor
): ViewModel() {

    fun init() {
        viewModelScope.launch(Dispatchers.IO) {
            val list = interactor.fetchCharactersList(START_CHARACTERS_PAGE)
        }
    }

    companion object {

        private const val START_CHARACTERS_PAGE = 1
    }
}
