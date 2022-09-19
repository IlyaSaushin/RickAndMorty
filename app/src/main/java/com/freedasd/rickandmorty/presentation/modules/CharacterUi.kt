package com.freedasd.rickandmorty.presentation.modules

import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.freedasd.rickandmorty.core.Same
import com.freedasd.rickandmorty.presentation.mappers.BaseCharacterDomainToUiMapper
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

interface CharacterUi : Same<CharacterUi> {

    override fun same(data: CharacterUi) = data == this

    fun details(imageView: ImageView, characterName: TextView, alive: TextView, characterSpecies: TextView, characterGender: TextView, characterLocation: TextView)

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
    ) : CharacterUi {
        override fun details(
            imageView: ImageView,
            characterName: TextView,
            alive: TextView,
            characterSpecies: TextView,
            characterGender: TextView,
            characterLocation: TextView
        ) {
            Glide.with(imageView).load(image).into(imageView)
            characterName.text = name
            alive.text = isAlive
            characterSpecies.text = species
            characterGender.text = gender
            characterLocation.text = locationName
        }
    }
}