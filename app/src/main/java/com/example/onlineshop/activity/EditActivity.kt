package com.example.onlineshop.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.onlineshop.R
import com.example.onlineshop.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    private lateinit var binding:ActivityEditBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}