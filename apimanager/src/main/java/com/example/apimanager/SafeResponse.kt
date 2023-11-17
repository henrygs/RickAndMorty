package com.example.apimanager

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.HttpException
import java.io.IOException
import java.io.Serializable

open class SafeResponse<out T>: Serializable{
    data class Loading(val isLoading: Boolean) : SafeResponse<Nothing>()
    data class Success<out T>(val data: T? = null) : SafeResponse<T>()
    data class Error(val error: String) : SafeResponse<Nothing>()
}

//suspend fun <T> safeRequestError(request: suspend () -> T): SafeResponse<T> {
//    val throwable = Throwable()
//        return when (throwable) {
//            is IOException -> {
//                SafeResponse.Error(
//                    getErrorMessage(throwable.localizedMessage ?: throwable.message.getOrSafe())
//                )
//            }
//            is HttpException -> {
//
//                SafeResponse.Error(
//                    throwable.message.getOrSafe()
//                )
//            }
//            else -> {
//                SafeResponse.Error (
//                    getErrorMessage(throwable.localizedMessage ?: throwable.message.getOrSafe())
//                )
//            }
//        }
//
//}

private fun String?.getOrSafe(): String {
    return this ?: ""
}

private fun getErrorMessage(response: String?): String = response ?: "Ops. Ocoreu um problema. Por favor, tente novamente."