package com.example.onlineshop.fragment.bottomNav

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.R
import com.example.onlineshop.activity.ShopCartActivity
import com.example.onlineshop.databinding.FragmentShopCartBinding
import com.example.onlineshop.recyclerView.DataProductsShopCart
import com.example.onlineshop.recyclerView.RecyclerShopCart

class ShopCartFragment : Fragment() {
    private lateinit var binding: FragmentShopCartBinding
    private val dataRecycler = arrayOf(
        DataProductsShopCart(
            1,
            "پیرهن مردانه ال دی",
            "2,000,000",
            R.drawable.img_shirt1
        ),
        DataProductsShopCart(
            2,
            "مانتو بافت زنانه اس ام",
            "1,000,000",
            R.drawable.img_shirt5
        ),
        DataProductsShopCart(
            3,
            "مانتو بافت زنانه اچ دی",
            "3,000,000",
            R.drawable.img_shirt3
        ),
        DataProductsShopCart(
            4,
            "مانتو بافت زنانه اچ ام",
            "6,000,000",
            R.drawable.img_shirt4
        )

    )


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShopCartBinding.inflate(inflater)
        binding.startActivity.setOnClickListener {
            startActivity(Intent(requireContext(),ShopCartActivity::class.java))
        }
        setRecycler()
        return binding.root

    }

    private fun setRecycler() {


        val adapter = RecyclerShopCart(requireActivity(), dataRecycler)
        binding.recyclerView.layoutManager = LinearLayoutManager(
            requireActivity(),
            RecyclerView.VERTICAL,
            false
        )
        binding.recyclerView.adapter = adapter
    }
}