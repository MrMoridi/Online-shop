package com.example.onlineshop.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.R
import com.example.onlineshop.databinding.ActivityOrdersBinding
import com.example.onlineshop.recyclerView.DataProductsOrder
import com.example.onlineshop.recyclerView.RecyclerOrderMainActivity

class OrdersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOrdersBinding

    private val dataOrder = arrayOf(
        DataProductsOrder(
            1,
            "ست سویشرت و شلوار مردانه",
            "2/500/000",
            "12345",
            R.drawable.img_shirt5,
            "2 فروردین 1402",
            "پرداخت موفق"
        ),
        DataProductsOrder(
            2,
            "ست سویشرت و شلوار مردانه",
            "2/340/000",
            "12347",
            R.drawable.img_shirt7,
            "27 تیر 1402",
            "پرداخت موفق"
        ),
        DataProductsOrder(
            3,
            "ست سویشرت و شلوار مردانه",
            "1/000/000",
            "12340",
            R.drawable.img_shirt4,
            "19 دی 1401",
            "پرداخت موفق"
        )

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrdersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setRecyclerOrder()

    }

    private fun setRecyclerOrder() {
        val adapter = RecyclerOrderMainActivity(this, dataOrder)
        binding.recyclerView.layoutManager = LinearLayoutManager(
            this,
            RecyclerView.VERTICAL,
            false
        )
        binding.recyclerView.adapter = adapter
    }
}