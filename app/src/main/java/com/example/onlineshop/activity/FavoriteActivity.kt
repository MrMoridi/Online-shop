package com.example.onlineshop.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.R
import com.example.onlineshop.databinding.ActivityFavoriteBinding
import com.example.onlineshop.recyclerView.DataProductsFavorite
import com.example.onlineshop.recyclerView.RecyclerFavorite

class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding:ActivityFavoriteBinding
    private val dataFavorite = arrayOf(
        DataProductsFavorite(
            1,
            "پیرهن مردانه ال دی",
            "2,000,000",
            "3,000,000",
            R.drawable.img_shirt1
        ),
        DataProductsFavorite(
            2,
            "مانتو بافت زنانه اس ام",
            "1,000,000",
            "2,000,000",
            R.drawable.img_shirt5
        ),
        DataProductsFavorite(
            3,
            "مانتو بافت زنانه اچ دی",
            "3,000,000",
            "3,600,000",
            R.drawable.img_shirt3
        ),
        DataProductsFavorite(
            4,
            "مانتو بافت زنانه اچ ام",
            "6,000,000",
            "8,760,000",
            R.drawable.img_shirt4
        ),
        DataProductsFavorite(
            5,
            "پیرهن مردانه ال دی",
            "2,000,000",
            "3,000,000",
            R.drawable.img_shirt1
        ),
        DataProductsFavorite(
            6,
            "مانتو بافت زنانه اس ام",
            "1,000,000",
            "2,000,000",
            R.drawable.img_shirt5
        )

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRecyclerFavorite()
    }

    private fun setRecyclerFavorite() {


        val adapter = RecyclerFavorite(this, dataFavorite)
        binding.recyclerView.layoutManager = GridLayoutManager(
            this,
            2,
            RecyclerView.HORIZONTAL,
            true
        )
        binding.recyclerView.adapter = adapter
    }
}