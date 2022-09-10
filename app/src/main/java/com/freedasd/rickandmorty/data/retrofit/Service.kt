package com.freedasd.rickandmorty.data.retrofit

import retrofit2.http.GET

interface Service {

    @GET("character")
    suspend fun charactersList() : CharacterApi
}