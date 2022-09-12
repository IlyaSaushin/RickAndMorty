package com.freedasd.rickandmorty.presentation.modules

sealed class CharacterListUi {

    data class Success(private val list: List<CharacterUi>) : CharacterListUi()

    data class Fail(private val ex: Exception) : CharacterListUi()
}