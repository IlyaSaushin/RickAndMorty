package com.freedasd.rickandmorty.domain.modules

import com.freedasd.rickandmorty.data.modules.CharacterData
import com.freedasd.rickandmorty.presentation.mappers.BaseCharacterDomainToUiMapper
import com.freedasd.rickandmorty.presentation.modules.CharacterUi
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

interface CharacterDomain {

    fun mapToUi(mapper: BaseCharacterDomainToUiMapper) : CharacterUi

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
    ) : CharacterDomain {

        override fun mapToUi(mapper: BaseCharacterDomainToUiMapper) = CharacterUi.Base(
            id,
            name,
            isAlive,
            species,
            type,
            gender,
            fromName,
            fromLink,
            locationName,
            locationLink,
            image,
            episode,
            url,
            created
        )
    }
}