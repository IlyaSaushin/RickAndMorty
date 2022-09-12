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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val service = RetrofitClient.buildService()

    fun init() {
        viewModelScope.launch(Dispatchers.IO) {
            val list = service.charactersList()
            Log.d("tag", "init: $list")
        }
    }
}
