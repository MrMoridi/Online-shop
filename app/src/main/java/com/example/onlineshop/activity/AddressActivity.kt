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
import com.example.onlineshop.databinding.ActivityAddressBinding
import com.example.onlineshop.recyclerView.DataProductsAddress
import com.example.onlineshop.recyclerView.RecyclerAddress

class AddressActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddressBinding
    private val dataRecycler = arrayOf(
        DataProductsAddress(
            1,
            "محمد عزیزی",
            "بیرجند - غفاری 16 - پلاک 25",
            "1759279180",
            "09018574819",
            true

        ),
        DataProductsAddress(
            2,
            "صالح رضایی زفره",
            "اصفهان - روستای زفره - جاده اردستان - کوچه یاس - پلاک 2",
            "1759290180",
            "09018679249",
            false
        ),
        DataProductsAddress(
            3,
            "یاسین مریدی",
            "هرمزگان - رودان - پلاک 13",
            "17254679180",
            "09011234819",
            false
        )

    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddressBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRecyclerBottom()
        binding.imgProfile.setOnClickListener {
            customDialog(this)
        }

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

    private fun setRecyclerBottom() {


        val adapter = RecyclerAddress(this, dataRecycler)
        binding.recyclerView.layoutManager = LinearLayoutManager(
            this,
            RecyclerView.VERTICAL,
            false
        )
        binding.recyclerView.adapter = adapter
    }
}