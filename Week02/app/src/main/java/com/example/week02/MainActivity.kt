package com.example.week02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.week02.databinding.ActivityMainBinding
import com.example.week02.viewbinding.Fragment1
import com.example.week02.viewbinding.Fragment2
import com.example.week02.databinding.Fragment3

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = MyViewModelFactory(initialCount = 10)
        viewModel = ViewModelProvider(this, factory)[MyViewModel::class.java]

        replaceFragment(Fragment1())
        binding.bottomNavi.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu1 -> {
                    replaceFragment(Fragment1())
                    return@setOnItemSelectedListener true
                }
                R.id.menu2 -> {
                    replaceFragment(Fragment2())
                    return@setOnItemSelectedListener true
                }
                else -> return@setOnItemSelectedListener false
            }

        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.layout_frame, fragment)
        fragmentTransaction.commit()
    }
}