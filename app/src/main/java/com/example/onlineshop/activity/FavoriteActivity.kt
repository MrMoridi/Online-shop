package com.example.onlineshop.activity

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.R
import com.example.onlineshop.databinding.ActivityFavoriteBinding
import com.example.onlineshop.fragment.bottomNav.CategoryFragment
import com.example.onlineshop.fragment.bottomNav.HomeFragment
import com.example.onlineshop.fragment.bottomNav.ProfileFragment
import com.example.onlineshop.fragment.bottomNav.ShopCartFragment
import com.example.onlineshop.recyclerView.DataProductsFavorite
import com.example.onlineshop.recyclerView.RecyclerFavorite

class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteBinding
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
        binding.imgProfile.setOnClickListener {
            customDialog(this)
        }

        binding.frameLayoutHome.setOnClickListener {
            selectFragment(HomeFragment())
            binding.frameLayoutSelectHome.visibility = View.VISIBLE
            binding.frameLayoutSelectCategory.visibility = View.INVISIBLE
            binding.frameLayoutSelectProfile.visibility = View.INVISIBLE
            binding.frameLayoutSelectShopCart.visibility = View.INVISIBLE
        }
        binding.frameLayoutProfile.setOnClickListener {
            selectFragment(ProfileFragment())
            binding.frameLayoutSelectHome.visibility = View.INVISIBLE
            binding.frameLayoutSelectCategory.visibility = View.INVISIBLE
            binding.frameLayoutSelectProfile.visibility = View.VISIBLE
            binding.frameLayoutSelectShopCart.visibility = View.INVISIBLE
        }
        binding.frameLayoutCategory.setOnClickListener {
            selectFragment(CategoryFragment())
            binding.frameLayoutSelectHome.visibility = View.INVISIBLE
            binding.frameLayoutSelectCategory.visibility = View.VISIBLE
            binding.frameLayoutSelectProfile.visibility = View.INVISIBLE
            binding.frameLayoutSelectShopCart.visibility = View.INVISIBLE
        }
        binding.frameLayoutShopCart.setOnClickListener {
            selectFragment(ShopCartFragment())
            binding.frameLayoutSelectHome.visibility = View.INVISIBLE
            binding.frameLayoutSelectCategory.visibility = View.INVISIBLE
            binding.frameLayoutSelectProfile.visibility = View.INVISIBLE
            binding.frameLayoutSelectShopCart.visibility = View.VISIBLE
        }
        exit()
    }

    private fun exit() {
        binding.imgExit.setOnClickListener {
            finish()
        }
    }

    private fun selectFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, fragment)
            .commit()
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
            (context).window.decorView.alpha = 1f
        }
        dialog.show()

        val txtUsername = dialog.findViewById<TextView>(R.id.username)
        txtUsername.text = username
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