package com.freedasd.rickandmorty.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.freedasd.rickandmorty.presentation.modules.CharacterUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface CharacterListRender {

    suspend fun fetchCharacterList(list: List<CharacterUi>)

    fun observeCharacterListLiveData(owner: LifecycleOwner, observer: Observer<List<CharacterUi>>)

    class Base @Inject constructor(): CharacterListRender {

        private val characterListLiveData = MutableLiveData<List<CharacterUi>>()

        override suspend fun fetchCharacterList(list: List<CharacterUi>) {
            withContext(Dispatchers.Main) {
                characterListLiveData.value = list
            }
        }

        override fun observeCharacterListLiveData(
            owner: LifecycleOwner,
            observer: Observer<List<CharacterUi>>
        ) {
            characterListLiveData.observe(owner, observer)
        }
    }
}