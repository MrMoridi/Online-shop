package com.example.onlineshop.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.onlineshop.R
import com.example.onlineshop.databinding.FragmentHomeBinding
import com.example.onlineshop.databinding.FragmentShopCartBinding

class ShopCartFragment : Fragment() {
    private lateinit var binding: FragmentShopCartBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShopCartBinding.inflate(inflater)
        return binding.root

    }
}