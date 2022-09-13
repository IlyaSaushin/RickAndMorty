package com.freedasd.rickandmorty.data.mappers

import com.freedasd.rickandmorty.core.BaseMapper
import com.freedasd.rickandmorty.data.modules.CharacterData
import com.freedasd.rickandmorty.data.retrofit.CharactersResult
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

class CharacterCloudToDataMapper @Inject constructor() {

    fun map(data: CharactersResult) = CharacterData.Base(
        data.id,
        data.name,
        data.isAlive,
        data.species,
        data.type,
        data.gender,
        data.origin.name,
        data.origin.location,
        data.location.name,
        data.location.url,
        data.image,
        data.episode,
        data.url,
        data.created
        )
}