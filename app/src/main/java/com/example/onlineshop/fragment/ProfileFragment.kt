package com.example.onlineshop.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.onlineshop.R
import com.example.onlineshop.databinding.FragmentHomeBinding
import com.example.onlineshop.databinding.FragmentProfileBinding
import com.example.onlineshop.databinding.FragmentShopCartBinding

class ProfileFragment: Fragment() {
    private lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater)
        return binding.root

    }
}