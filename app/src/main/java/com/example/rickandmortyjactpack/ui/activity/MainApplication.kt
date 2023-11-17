package com.example.rickandmortyjactpack.ui.activity

import android.app.Application
import com.example.apimanager.di.ApiManagerModule
import com.example.rickandmortyjactpack.di.modulesViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class MainApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            androidLogger()
            val modules = arrayListOf<Module>().apply {
                add(ApiManagerModule.apiModules)
                add(modulesViewModel)
            }
            modules(modules)
        }
    }
}