package com.freedasd.rickandmorty.domain.mappers

import com.freedasd.rickandmorty.data.mappers.CharacterDataToDomainMapper
import com.freedasd.rickandmorty.domain.modules.CharacterDomain
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

class BaseCharacterDataToDomainMapper @Inject constructor() : CharacterDataToDomainMapper {

    override fun mapToDomain(
        id: Int,
        name: String,
        isAlive: String,
        species: String,
        type: String,
        gender: String,
        fromName: String,
        fromLink: String,
        locationName: String,
        locationLink: String,
        image: String,
        episode: List<String>,
        url: String,
        created: String
    ) = CharacterDomain.Base(
        id, name, isAlive, species, type, gender, fromName, fromLink, locationName, locationLink, image, episode, url, created
    )
}