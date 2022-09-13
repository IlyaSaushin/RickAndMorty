package com.freedasd.rickandmorty.presentation.mappers

import com.freedasd.rickandmorty.domain.mappers.CharacterDomainToUiMapper
import com.freedasd.rickandmorty.presentation.modules.CharacterUi
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

class BaseCharacterDomainToUiMapper @Inject constructor() : CharacterDomainToUiMapper {

    override fun mapToUi(
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
    ) = CharacterUi.Base(
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