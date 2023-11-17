package com.example.rickandmortyjactpack.repository

import com.example.rickandmortyjactpack.model.GetPersons

interface HomeRepositoryInterface {

    suspend fun homeRepository() : GetPersons
}
