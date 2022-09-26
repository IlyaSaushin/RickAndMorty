package com.freedasd.rickandmorty.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.freedasd.rickandmorty.presentation.modules.CharacterUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.internal.notify
import okhttp3.internal.notifyAll
import javax.inject.Inject

interface CharacterListRender {

    suspend fun fetchCharacterList(list: List<CharacterUi>)

    fun observeCharacterListLiveData(owner: LifecycleOwner, observer: Observer<List<CharacterUi>>)

    class Base @Inject constructor(): CharacterListRender {

        private val characterListLiveData = MutableLiveData<ArrayList<CharacterUi>>()

        override suspend fun fetchCharacterList(list: List<CharacterUi>) {
            withContext(Dispatchers.Main) {
                characterListLiveData.plusAssign(list)
            }
        }

        override fun observeCharacterListLiveData(
            owner: LifecycleOwner,
            observer: Observer<List<CharacterUi>>
        ) {
            characterListLiveData.observe(owner, observer)
        }
    }

    operator fun <T> MutableLiveData<ArrayList<T>>.plusAssign(values: List<T>) {
        val value = this.value ?: arrayListOf()
        value.addAll(values)
        this.value = value
    }
}