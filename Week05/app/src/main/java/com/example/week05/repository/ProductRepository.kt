package com.example.week05.repository

import com.example.week05.model.ProductResponse
import retrofit2.Response

interface ProductRepository {
    suspend fun getPost(number: Int): Response<ProductResponse>
}