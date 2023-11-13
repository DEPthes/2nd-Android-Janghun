package com.example.week02

import android.util.Log
import androidx.lifecycle.ViewModel

class MyViewModel(initialCount: Int): ViewModel(){
    private var count: Int = 0

    init {
        count = initialCount
    }

    fun getCount(): Int {
        return count
    }

    fun doCountPlus(){
        count++
        Log.d("VM", "COUNT: $count")
    }

    fun doCountMinus(){
        count--
        Log.d("VM", "COUNT: $count")
    }
}