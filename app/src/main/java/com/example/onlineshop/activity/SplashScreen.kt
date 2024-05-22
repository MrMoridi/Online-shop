package com.example.onlineshop.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import com.example.onlineshop.databinding.ActivitySplashScreenBinding
import com.example.onlineshop.databinding.NoInternetBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val sharedPreferences = getSharedPreferences("login_info", Context.MODE_PRIVATE)
        val check = sharedPreferences.getString("check", "")
        binding.logoImg.animate().alpha(1f).duration = 4000
        binding.TxtName.animate().rotation(360f).duration = 3000

        Handler(Looper.getMainLooper()).postDelayed({


            if (isConnected()) {
                if (check!!.isNotEmpty()) {
                    startActivity(Intent(this@SplashScreen, MainActivity::class.java))
                    finish()
                } else {
                    startActivity(Intent(this@SplashScreen, LoginActivity::class.java))
                    finish()
                }
            } else {
                sheetDialog()
            }
        }, 4000)

    }

    private fun sheetDialog() {

        val dialog = BottomSheetDialog(this)

// فایل xml طراحی شده
        val view = NoInternetBinding.inflate(layoutInflater)

// دو دکمه موجود در فایل xml
        view.btnOnCreate.setOnClickListener { recreate() }
        view.btnSetting.setOnClickListener {
            startActivity(Intent(Settings.ACTION_WIFI_SETTINGS))
        }

// اضافه کردن view به رابط کاربری
        dialog.setContentView(view.root)

// کاربر نمی‌تواند با ضربه زدن به بیرون از پنجره آن را ببندد.
        dialog.setCancelable(false)
        dialog.show()
    }

    private fun isConnected(): Boolean {
        val result: Boolean
        val connectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetwork ?: return false
        val actNw =
            connectivityManager.getNetworkCapabilities(networkInfo) ?: return false

        result = when {
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true

            else -> false

        }
        return result
    }

}