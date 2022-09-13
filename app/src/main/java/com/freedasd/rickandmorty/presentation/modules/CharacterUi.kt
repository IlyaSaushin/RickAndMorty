package com.freedasd.rickandmorty.presentation.modules

import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

interface CharacterUi {

    class Base @Inject constructor(
        private val id: Int,
        private val name: String,
        private val isAlive: String,
        private val species: String,
        private val type: String,
        private val gender: String,
        private val fromName: String,
        private val fromLink: String,
        private val locationName: String,
        private val locationLink: String,
        private val image: String,
        private val episode: List<String>,
        private val url: String,
        private val created: String
    ) : CharacterUi
}