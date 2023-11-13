package com.example.week02

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.week02.databinding.ActivitySubBinding
import com.example.week02.databinding.Fragment3
import com.example.week02.databinding.Fragment4

class SubActivity: AppCompatActivity() {
    private lateinit var binding: ActivitySubBinding
    private lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = MyViewModelFactory(initialCount = 20)
        viewModel = ViewModelProvider(this, factory)[MyViewModel::class.java]

        replaceFragment(Fragment3())
        binding.bottomNavi.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu1 -> {
                    replaceFragment(Fragment3())
                    return@setOnItemSelectedListener true
                }
                R.id.menu2 -> {
                    replaceFragment(Fragment4())
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