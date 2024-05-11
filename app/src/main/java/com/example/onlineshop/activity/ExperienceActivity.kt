package com.example.onlineshop.activity

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.R
import com.example.onlineshop.databinding.ActivityExperBinding
import com.example.onlineshop.fragment.bottomNav.CategoryFragment
import com.example.onlineshop.fragment.bottomNav.HomeFragment
import com.example.onlineshop.fragment.bottomNav.ProfileFragment
import com.example.onlineshop.fragment.bottomNav.ShopCartFragment
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
        binding.imgProfile.setOnClickListener {
            customDialog(this)
        }
        exit()
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
            (context as Activity).window.decorView.alpha = 1f
        }
        dialog.show()

        val txtUsername = dialog.findViewById<TextView>(R.id.username)
        txtUsername.text = username
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