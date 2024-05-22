package com.example.onlineshop.fragment.top

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.onlineshop.databinding.FragmentWomanBinding

class WomanTopFragment : Fragment() {
    private lateinit var binding: FragmentWomanBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWomanBinding.inflate(layoutInflater)
        return binding.root

    }


}