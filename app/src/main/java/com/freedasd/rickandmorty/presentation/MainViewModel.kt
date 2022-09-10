package com.freedasd.rickandmorty.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.freedasd.rickandmorty.data.retrofit.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val service = RetrofitClient.buildService()

    fun init() {
        viewModelScope.launch(Dispatchers.IO) {
            val list = service.charactersList()
            Log.d("tag", "init: $list")
        }
    }

}
