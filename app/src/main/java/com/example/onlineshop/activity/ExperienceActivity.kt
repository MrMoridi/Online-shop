package com.example.onlineshop.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.onlineshop.R
import com.example.onlineshop.databinding.ActivityExperBinding
import com.example.onlineshop.databinding.ActivityPasswordBinding

class ExperienceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityExperBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExperBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}