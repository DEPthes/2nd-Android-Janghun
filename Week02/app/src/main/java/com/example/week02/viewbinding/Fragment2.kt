package com.example.week02.viewbinding

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.week02.MyViewModel
import com.example.week02.SubActivity
import com.example.week02.databinding.Fragment2Binding

class Fragment2 : Fragment() {
    private var _binding: Fragment2Binding? = null
    private val binding get() = _binding!!
    private lateinit var vm: MyViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        _binding = Fragment2Binding.inflate(inflater, container, false)
        Log.d("Fragment2", "onCreateView()")
        vm = ViewModelProvider(requireActivity())[MyViewModel::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvCount.text = vm.getCount().toString()

        binding.btnChange1.setOnClickListener{
            val intent = Intent(context, SubActivity::class.java)

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
        _binding = null
        Log.d("Fragment2", "onDestoryView()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Fragment2", "onDestory()")
    }
}