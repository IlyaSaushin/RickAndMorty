package com.freedasd.rickandmorty.data.modules

import com.freedasd.rickandmorty.domain.mappers.BaseCharacterDataToDomainMapper
import com.freedasd.rickandmorty.domain.modules.CharacterDomain
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

interface CharacterData {

    fun mapToDomain(mapper: BaseCharacterDataToDomainMapper) : CharacterDomain

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
    ) : CharacterData {

        override fun mapToDomain(mapper: BaseCharacterDataToDomainMapper) = CharacterDomain.Base(
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