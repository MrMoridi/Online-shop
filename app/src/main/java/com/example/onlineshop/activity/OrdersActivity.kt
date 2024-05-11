package com.example.onlineshop.activity

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.TextView
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
        ),DataProductsOrder(
            4,
            "ست سویشرت",
            "1/040/000",
            "12380",
            R.drawable.img_shirt1,
            "9 شهریور 1401",
            "پرداخت موفق"
        ),DataProductsOrder(
            5,
            "ست سویشرت و شلوار",
            "2/000/000",
            "12310",
            R.drawable.img_shirt3,
            "11 فروردین 1402",
            "پرداخت موفق"
        ),DataProductsOrder(
            6,
            " سویشرت و شلوار",
            "1/000/000",
            "13340",
            R.drawable.img_shirt6,
            "21 خرداد 1402",
            "پرداخت موفق"
        )

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrdersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setRecyclerOrder()
        binding.imgProfile.setOnClickListener {
            customDialog(this)
        }

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

    private fun customDialog(context: Context) {
        val username = intent.getStringExtra("username") ?: "نام کاربری"

        // تار کردن صفحه
        (context as Activity).window.decorView.alpha = 0.5f

        val dialog = Dialog(context)
        dialog.setContentView(R.layout.custom_dialog_home)
        dialog.setCancelable(true)
        dialog.setOnDismissListener {
            // برگرداندن شفافیت به حالت اولیه
            (context as Activity).window.decorView.alpha = 1f
        }
        dialog.show()

        val txtUsername = dialog.findViewById<TextView>(R.id.username)
        txtUsername.text = username
    }
}