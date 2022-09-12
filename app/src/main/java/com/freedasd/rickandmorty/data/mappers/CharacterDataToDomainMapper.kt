package com.freedasd.rickandmorty.data.mappers

import com.freedasd.rickandmorty.domain.modules.CharacterDomain

interface CharacterDataToDomainMapper {

    fun mapToDomain(
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
    ) : CharacterDomain
}