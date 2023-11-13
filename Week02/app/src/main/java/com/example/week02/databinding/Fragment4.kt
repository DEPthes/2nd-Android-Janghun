package com.example.week02.databinding

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.week02.MainActivity
import com.example.week02.MyViewModel
import com.example.week02.R
import com.example.week02.databinding.Fragment3Binding

class Fragment4 : Fragment() {
    private lateinit var binding: Fragment4Binding
    private lateinit var vm: MyViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_4, container, false)
        Log.d("Fragment4", "onCreateView()")
        vm = ViewModelProvider(requireActivity())[MyViewModel::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvCount.text = vm.getCount().toString()

        binding.btnChange2.setOnClickListener{
            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
        }
        binding.btnPlus.setOnClickListener{
            vm.doCountPlus()
            binding.tvCount.text = vm.getCount().toString()
        }
        binding.btnMinus.setOnClickListener{
            vm.doCountMinus()
            binding.tvCount.text = vm.getCount().toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("Fragment4", "onDestoryView()")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("Fragment4", "onDestory()")

    }
}