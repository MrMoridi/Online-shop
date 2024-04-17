package com.example.onlineshop.fragment.top

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.onlineshop.databinding.FragmentTshirtBinding

class TishirtFragment:Fragment() {

    private lateinit var binding: FragmentTshirtBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTshirtBinding.inflate(layoutInflater)
        return binding.root

    }
}