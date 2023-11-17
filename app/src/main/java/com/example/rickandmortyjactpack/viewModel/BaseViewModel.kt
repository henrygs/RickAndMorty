package com.example.rickandmortyjactpack.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apimanager.SafeResponse
import com.example.rickandmortyjactpack.model.GetPerson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel<T>: ViewModel() {
    protected val dispatcher: CoroutineContext = Dispatchers.Main + SupervisorJob()
    protected val _liveData = MutableLiveData<SafeResponse<T>>()
    val liveData : MutableLiveData<SafeResponse<T>>
        get() = _liveData
}