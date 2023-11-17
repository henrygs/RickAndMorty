package com.example.rickandmortyjactpack.di

import com.example.apimanager.HttpClient
import com.example.apimanager.HttpClientInterface
import com.example.rickandmortyjactpack.api.HomeApi
import com.example.rickandmortyjactpack.repository.HomeRepositoryImpl
import com.example.rickandmortyjactpack.repository.HomeRepositoryInterface
import com.example.rickandmortyjactpack.viewModel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val modulesViewModel = module {
    factory<HttpClientInterface> {HttpClient()}
    factory { get<HttpClientInterface>().create(HomeApi::class.java) }
    factory<HomeRepositoryInterface> { HomeRepositoryImpl(get()) }
    viewModel { HomeViewModel(get()) }
}
