package com.example.rickandmortyjactpack.model

import com.example.rickandmortyjactpack.model.getPerson.Location
import com.example.rickandmortyjactpack.model.getPerson.Origin

data class GetPerson(
    val created: String? = null,
    val episode: List<String> = listOf(),
    val gender: String? = null,
    val id: Int? = null,
    val image: String? = null,
    val location: Location? = null,
    val name: String? = null,
    val origin: Origin? = null,
    val species: String? = null,
    val status: String? = null,
    val type: String? = null,
    val url: String? = null,
    var error: String? = null
)