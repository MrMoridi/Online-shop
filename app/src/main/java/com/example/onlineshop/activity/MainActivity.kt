package com.example.onlineshop.activity

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import com.example.onlineshop.R
import com.example.onlineshop.databinding.ActivityMainBinding
import com.example.onlineshop.fragment.CategoryFragment
import com.example.onlineshop.fragment.HomeFragment
import com.example.onlineshop.fragment.ProfileFragment
import com.example.onlineshop.fragment.ShopCartFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgProfile.setOnClickListener {
            customDialog(this)
        }

        setFragment()
        setOnClickListeners()

    }

   /* override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search,menu)
        val item = menu?.findItem(R.id.searchView)
        val searchView = item?.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                TODO("Not yet implemented")
            }
        })
        return true
    }*/

    private fun setFragment() {
        //انتخاب پیشفرص فرگمنت خانه
        selectFragment(HomeFragment())

        binding.frameLayoutHome.setOnClickListener { selectFragment(HomeFragment()) }
        binding.frameLayoutProfile.setOnClickListener { selectFragment(ProfileFragment()) }
        binding.frameLayoutCategory.setOnClickListener { selectFragment(CategoryFragment()) }
        binding.frameLayoutShopCart.setOnClickListener { selectFragment(ShopCartFragment()) }
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

    private fun setOnClickListeners() {
        val frames = listOf(
            binding.frameLayoutHome to binding.frameLayoutSelectHome,
            binding.frameLayoutCategory to binding.frameLayoutSelectCategory,
            binding.frameLayoutProfile to binding.frameLayoutSelectProfile,
            binding.frameLayoutShopCart to binding.frameLayoutSelectShopCart
        )

        frames.forEach { (frameLayout, selectLayout) ->
            frameLayout.setOnClickListener {
                frames.forEach { (_, otherSelectLayout) ->
                    otherSelectLayout.alpha = 0f
                    otherSelectLayout.visibility = View.INVISIBLE
                }
                selectLayout.alpha = 1f
                selectLayout.visibility = View.VISIBLE
            }
        }
    }
}


