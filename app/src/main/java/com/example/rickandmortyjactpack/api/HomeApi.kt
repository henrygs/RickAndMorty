package com.example.rickandmortyjactpack.api

import com.example.rickandmortyjactpack.model.GetPerson
import com.example.rickandmortyjactpack.model.GetPersons
import retrofit2.http.GET

interface HomeApi {

    @GET("character")
    suspend fun getCharacterApi(): GetPersons
}