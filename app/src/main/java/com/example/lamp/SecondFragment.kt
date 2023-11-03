package com.example.lamp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lamp.databinding.FragmentScandBinding

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentScandBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentScandBinding.inflate(layoutInflater)
        binding.btnStart.setOnClickListener {
            findNavController().navigate(R.id.action_scandFragment_to_firstFragment)
        }
        return binding.root


    }


}