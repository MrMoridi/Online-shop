package com.example.onlineshop.activity

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.onlineshop.R
import com.example.onlineshop.databinding.ActivityMainBinding
import com.example.onlineshop.fragment.bottomNav.CategoryFragment
import com.example.onlineshop.fragment.bottomNav.HomeFragment
import com.example.onlineshop.fragment.bottomNav.ProfileFragment
import com.example.onlineshop.fragment.bottomNav.ShopCartFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        exit()
        binding.imgProfile.setOnClickListener {
            customDialog(this)
        }

        //انتخاب پیشفرص فرگمنت خانه
        selectFragment(HomeFragment())
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

        val sharedPreferences = getSharedPreferences("login_info", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("check", "yes")
        editor.apply()
    }


    private fun selectFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, fragment)
            .commit()
    }

    private fun customDialog(context: Context) {
        val username = intent.getStringExtra("username") ?: "نام کاربری"


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

    private fun exit() {
        binding.imgExit.setOnClickListener {
            finish()
        }
    }

}


