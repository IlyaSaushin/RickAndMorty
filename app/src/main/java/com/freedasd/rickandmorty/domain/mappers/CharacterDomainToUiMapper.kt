package com.freedasd.rickandmorty.domain.mappers

import com.freedasd.rickandmorty.presentation.modules.CharacterUi

interface CharacterDomainToUiMapper {

    fun mapToUi(
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
    ) : CharacterUi
}
