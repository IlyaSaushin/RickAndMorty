package com.freedasd.rickandmorty.data.retrofit

import retrofit2.http.GET
import retrofit2.http.Query

interface Service {

    @GET("character")
    suspend fun charactersList(
        @Query ("page") page: Int
    ) : CharacterApi
}