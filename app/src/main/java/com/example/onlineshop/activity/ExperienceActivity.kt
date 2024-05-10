package com.example.onlineshop.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.R
import com.example.onlineshop.databinding.ActivityExperBinding
import com.example.onlineshop.recyclerView.DataProductsExperience
import com.example.onlineshop.recyclerView.RecyclerExperience

class ExperienceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityExperBinding
    private val dataExperience = arrayOf(
        DataProductsExperience(
            1,
            "پیرهن مردانه ال دی",
            "2,000,000",
            R.drawable.img_shirt6,
            "3.5"
        ),
        DataProductsExperience(
            2,
            "پیرهن مردانه",
            "4,000,000",
            R.drawable.img_shirt5,
            "4"
        ),
        DataProductsExperience(
            3,
            "تیشرت مردانه ال دی",
            "2,340,000",
            R.drawable.img_shirt4,
            "5"
        ),
        DataProductsExperience(
            4,
            "پیرهن زنانه ال پی",
            "1,000,000",
            R.drawable.img_shirt3,
            "3"
        )

    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExperBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRecycler()
    }

    private fun setRecycler() {


        val adapter = RecyclerExperience(this, dataExperience)
        binding.recyclerView.layoutManager = LinearLayoutManager(
            this,
            RecyclerView.VERTICAL,
            false
        )
        binding.recyclerView.adapter = adapter
    }
}