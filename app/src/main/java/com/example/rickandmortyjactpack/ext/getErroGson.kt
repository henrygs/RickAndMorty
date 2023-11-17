package com.example.rickandmortyjactpack.ext

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.HttpException

fun Throwable.getError(): String {
        val gson = Gson()
        val type = object : TypeToken<ErrorResponse>() {}.type
        return gson.fromJson<ErrorResponse>((this as HttpException).response()?.errorBody()?.charStream()?.readText(), type).error
}

data class ErrorResponse(val error : String)