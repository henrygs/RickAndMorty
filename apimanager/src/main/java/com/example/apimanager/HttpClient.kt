package com.example.apimanager

import android.app.Application
import com.example.apimanager.interceptors.ResponseInterceptor
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class HttpClient: HttpClientInterface {

    private companion object {
        private const val CACHE_OF_10_MB: Long = 10 * 1024 * 1024
    }

    private lateinit var httpClient: OkHttpClient.Builder


    override fun <S> create(
        serviceClass: Class<S>
    ): S {

        setClient()
        setLogs()

        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(serviceClass)
    }

    private fun setClient() {

        httpClient = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)

        with(httpClient) {
            let {
                addInterceptor(ResponseInterceptor(disableRetry = true))
            }
        }

    }

    private fun setLogs() {
        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            httpClient.addInterceptor(logging)
        }
    }
}