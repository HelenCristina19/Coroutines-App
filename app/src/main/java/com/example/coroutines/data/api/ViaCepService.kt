package com.example.coroutines.data.api

import com.example.coroutines.data.model.Address
import retrofit2.http.GET
import retrofit2.http.Path

interface ViaCepService {
    @GET("{cep}/json")
    suspend fun findAddress(@Path("cep") cep: String): Address
}