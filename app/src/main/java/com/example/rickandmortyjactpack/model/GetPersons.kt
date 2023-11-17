package com.example.rickandmortyjactpack.model

import com.example.rickandmortyjactpack.model.getPersons.Info
import com.example.rickandmortyjactpack.model.getPersons.Result

data class GetPersons(
    val info: Info,
    val results: List<Result>
)