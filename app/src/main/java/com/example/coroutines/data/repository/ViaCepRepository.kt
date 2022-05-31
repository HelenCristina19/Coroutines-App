package com.example.coroutines.data.repository

import com.example.coroutines.data.api.RetrofitGenerator
import com.example.coroutines.data.api.ViaCepService
import com.example.coroutines.data.model.Address
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class ViaCepRepository(
    private val api: ViaCepService = RetrofitGenerator.viaCepService
) {

    suspend fun findAddress(cep: String): Address {
        return withContext(Dispatchers.IO) {
            val address = api.findAddress(cep)
            if (address.error) throw CepNotFoundException("CEP inválido")
            address
        }
    }
}

class CepNotFoundException(message: String) : Throwable(message)