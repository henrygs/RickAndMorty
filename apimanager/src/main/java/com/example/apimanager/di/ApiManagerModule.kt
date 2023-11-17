package com.example.apimanager.di

import com.example.apimanager.HttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object ApiManagerModule {
     val apiModules = module {
        factory { HttpClient::class.java }
    }
}