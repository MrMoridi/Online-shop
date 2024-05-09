package com.example.onlineshop.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
            "09018574819"

        ),
        DataProductsAddress(
            2,
            "صالح رضایی زفره",
            "اصفهان - روستای زفره - جاده اردستان - کوچه یاس - پلاک 2",
            "1759290180",
            "09018679249"
        ),
        DataProductsAddress(
            3,
            "یاسین مریدی",
            "هرمزگان - رودان - پلاک 13",
            "17254679180",
            "09011234819"
        )

    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddressBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRecyclerBottom()
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