package com.example.week05.network

import com.example.week05.model.ProductResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("products/{number}")
    suspend fun getPost1(
        @Path("number") number: Int
    ): Response<ProductResponse>
}