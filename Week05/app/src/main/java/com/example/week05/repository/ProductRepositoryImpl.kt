package com.example.week05.repository

import com.example.week05.model.ProductResponse
import com.example.week05.network.RetrofitClient.api
import retrofit2.Response

class ProductRepositoryImpl: ProductRepository {
    override suspend fun getPost(number: Int): Response<ProductResponse> {
        return api.getPost1(number)
    }

}