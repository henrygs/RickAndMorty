package com.example.rickandmortyjactpack.ext

import com.example.rickandmortyjactpack.model.GetPerson
import com.example.rickandmortyjactpack.model.GetPersons
import com.example.rickandmortyjactpack.model.getPersons.Result

data class Person(val name: String?, val image: String?, val id: Int?)

fun List<Result>.persons(): List<Person> {
    return this.map { Person(name = it.name, image = it.image, id = it.id) }
}

