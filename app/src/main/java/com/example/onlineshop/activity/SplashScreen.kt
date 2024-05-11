package com.example.onlineshop.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.onlineshop.databinding.ActivitySplashScreenBinding

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.logoImg.animate().alpha(1f).duration = 4000
        binding.TxtName.animate().rotation(360f).duration = 3000

        val sharedPreferences = getSharedPreferences("login_info",Context.MODE_PRIVATE)
        val check = sharedPreferences.getString("check","")
        if (check!!.isNotEmpty()) {


            Handler(Looper.getMainLooper()).postDelayed({

                startActivity(Intent(this@SplashScreen, MainActivity::class.java))

                finish()
            }, 4000)
        }else{
            Handler(Looper.getMainLooper()).postDelayed({

                startActivity(Intent(this@SplashScreen, LoginActivity::class.java))

                finish()
            }, 4000)
        }
    }
}