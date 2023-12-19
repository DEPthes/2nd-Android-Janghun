package com.example.week05.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.week05.repository.ProductRepository
import java.lang.IllegalArgumentException

class MainViewModelProviderFactory(private val productRepository: ProductRepository): ViewModelProvider.Factory {
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(productRepository) as T
        }
        throw IllegalArgumentException("ViewModel class not found")
    }

}