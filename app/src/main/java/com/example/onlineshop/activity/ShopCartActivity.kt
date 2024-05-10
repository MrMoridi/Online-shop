package com.example.onlineshop.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.R
import com.example.onlineshop.databinding.ActivityShopCartBinding
import com.example.onlineshop.recyclerView.RecyclerCenterMainActivity

class ShopCartActivity : AppCompatActivity() {
    private lateinit var binding:ActivityShopCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShopCartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnChangeAddress.setOnClickListener {
            startActivity(Intent(this,AddressActivity::class.java))
        }

    }


}