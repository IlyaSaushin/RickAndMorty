package com.freedasd.rickandmorty.data.retrofit

import com.freedasd.rickandmorty.data.mappers.CharacterCloudToDataMapper
import com.freedasd.rickandmorty.data.modules.CharacterData
import com.google.gson.annotations.SerializedName

data class CharacterApi(
    @SerializedName("info") val info: CharactersInfo,
    @SerializedName("results") val results: List<CharactersResult>
)

data class CharactersInfo(
    @SerializedName("count") val count: Int,
    @SerializedName("pages") val pages: Int,
    @SerializedName("next") val next: String,
    @SerializedName("prev") val prev: String
)

data class CharactersResult(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("status") val isAlive: String,
    @SerializedName("species") val species: String,
    @SerializedName("type") val type: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("origin") val origin: CharacterOrigin,
    @SerializedName("location") val location: CharacterLocation,
    @SerializedName("image") val image: String,
    @SerializedName("episode") val episode: List<String>,
    @SerializedName("url") val url: String,
    @SerializedName("created") val created: String
) {
    fun map(mapper: CharacterCloudToDataMapper) = CharacterData.Base(
        id,
        name,
        isAlive,
        species,
        type,
        gender,
        origin.name,
        origin.location,
        location.name,
        location.url,
        image,
        episode,
        url,
        created
    )
}

data class CharacterOrigin(
    @SerializedName("name") val name: String,
    @SerializedName("url") val location: String
)

data class CharacterLocation(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)

//id	int	The id of the character.
//name	string	The name of the character.
//status	string	The status of the character ('Alive', 'Dead' or 'unknown').
//species	string	The species of the character.
//type	string	The type or subspecies of the character.
//gender	string	The gender of the character ('Female', 'Male', 'Genderless' or 'unknown').
//origin	object	Name and link to the character's origin location.
//location	object	Name and link to the character's last known location endpoint.
//image	string (url)	Link to the character's image. All images are 300x300px and most are medium shots or portraits since they are intended to be used as avatars.
//episode	array (urls)	List of episodes in which this character appeared.
//url	string (url)	Link to the character's own URL endpoint.
//created	string	Time at which the character was created in the database.