package com.example.coroutines.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coroutines.data.repository.ViaCepRepository
import kotlinx.coroutines.launch


class MainViewModel(
    private val repository: ViaCepRepository = ViaCepRepository()
) : ViewModel() {

    private val _state = MutableLiveData<String>()
    val state: LiveData<String> = _state

    fun findAddress(cep: String) = viewModelScope.launch {
        runCatching {
            repository.findAddress(cep)
        }.onSuccess { address ->
            _state.value = address.toString()
        }.onFailure { throwable ->
            _state.value = throwable.message
        }
    }
}