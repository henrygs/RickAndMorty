package com.example.rickandmortyjactpack.viewModel

import androidx.lifecycle.viewModelScope
import com.example.apimanager.SafeResponse
import com.example.rickandmortyjactpack.repository.HomeRepositoryInterface
import com.example.rickandmortyjactpack.ext.getError
import com.example.rickandmortyjactpack.model.GetPerson
import com.example.rickandmortyjactpack.model.GetPersons
import kotlinx.coroutines.launch

class HomeViewModel(private val homeRepository: HomeRepositoryInterface): BaseViewModel<GetPersons>() {

    fun getPersons() {
       viewModelScope.launch {
           _liveData.value =  SafeResponse.Loading(true)
            try{
                val response = homeRepository.homeRepository()
                _liveData.value =  SafeResponse.Loading(false)
               _liveData.value =  SafeResponse.Success(response)
            }catch (ex: Exception ) {
                _liveData.value =  SafeResponse.Loading(false)
                _liveData.value =  SafeResponse.Error(ex.getError())
            }
        }
    }
}