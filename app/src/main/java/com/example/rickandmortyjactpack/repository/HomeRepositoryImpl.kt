package com.example.rickandmortyjactpack.repository

import com.example.rickandmortyjactpack.api.HomeApi
import com.example.rickandmortyjactpack.model.GetPerson
import com.example.rickandmortyjactpack.model.GetPersons

class HomeRepositoryImpl(private val homeApi: HomeApi) : HomeRepositoryInterface {
    override suspend fun homeRepository(): GetPersons {
        return homeApi.getCharacterApi()
    }
}