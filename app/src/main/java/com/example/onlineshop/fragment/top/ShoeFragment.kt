package com.example.onlineshop.fragment.top

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.onlineshop.databinding.FragmentShoeBinding

class ShoeFragment : Fragment() {
    private lateinit var binding: FragmentShoeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShoeBinding.inflate(layoutInflater)
        return binding.root

    }
}