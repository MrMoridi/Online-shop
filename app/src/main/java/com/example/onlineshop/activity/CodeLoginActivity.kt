package com.example.onlineshop.activity

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.onlineshop.R
import com.example.onlineshop.androidWarpper.DeviceInfo
import com.example.onlineshop.databinding.ActivityCodeLoginBinding
import com.example.onlineshop.remote.RetrofitService
import com.example.onlineshop.remote.dataModel.GetApiModel
import com.example.onlineshop.remote.ext.ErrorUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Locale

class CodeLoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCodeLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCodeLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        start()
        buttonOk()

    }


    @SuppressLint("SetTextI18n")
    private fun start() {

        val email = intent.getStringExtra("email")

        countdownText(binding.txtTimer)

        binding.txtSendCode.text =
            "کد 6 رقمی ارسال شده به${email}خود را وارد کنید"

        binding.txtSendCode.layoutDirection = View.LAYOUT_DIRECTION_RTL
        try {
            binding.imgArrow.setOnClickListener { LoginActivity().sendCodeEmail(email!!) }
            binding.sendCode.setOnClickListener { LoginActivity().sendCodeEmail(email!!) }
        } catch (e: Exception) {
            Toast.makeText(this@CodeLoginActivity, "ایمیل وارد نشده است", Toast.LENGTH_SHORT).show()
        }
        binding.editEmail.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    LoginActivity::class.java
                )
            )

            finish()
        }


    }

    private fun buttonOk() {
        binding.btnSend.setOnClickListener {
            val code = binding.edtCode.text.toString()
            if (code.isEmpty()) {
                binding.edtCode.hint = "کد نمیتواند خالی باشد"
            } else {
                binding.viewCodeLogin.setBackgroundColor(0xFCF3EC)
                customDialog()
            }
        }

    }

    private fun countdownText(textView: TextView) {
        val countDownTimer = object : CountDownTimer(2 * 60 * 1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val minutes = millisUntilFinished / (60 * 1000)
                val seconds = (millisUntilFinished % (60 * 1000)) / 1000
                textView.text = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds)
            }

            @SuppressLint("SetTextI18n")
            override fun onFinish() {
                textView.text = "00:00"
            }
        }
        countDownTimer.start()
    }

    private fun verifyCode(androidId: String, code: String, email: String) {
        val service = RetrofitService.apiService

        CoroutineScope(Dispatchers.IO).launch {

            try {
                val response = service.verifyCode(androidId, code, email)

                if (response.isSuccessful) {
                    launch(Dispatchers.Main) {
                        val data = response.body() as GetApiModel

                        data.api

                        Toast.makeText(
                            this@CodeLoginActivity,
                            "به فروشگاه ما خوش آمدید",
                            Toast.LENGTH_SHORT
                        )
                            .show()

                        startActivity(
                            Intent(
                                this@CodeLoginActivity,
                                InformationActivity::class.java
                            )
                        )
                        finish()
                    }
                } else {
                    launch(Dispatchers.Main) {
                        Toast.makeText(
                            this@CodeLoginActivity,
                            ErrorUtils.getError(response),
                            Toast.LENGTH_SHORT
                        )
                            .show()

                        binding.txtError.visibility = View.VISIBLE
                    }
                }
            } catch (e: Exception) {
                Log.i("SERVER_ERROR", e.message.toString())
            }

        }
    }

    private fun customDialog() {
        val email = intent.getStringExtra("email")
        val code = binding.edtCode.text.toString()
        val androidId = DeviceInfo.getAndroidId(this@CodeLoginActivity)
        val dialog = Dialog(this@CodeLoginActivity)
        dialog.setContentView(R.layout.custom_dialog_login)
        dialog.setCancelable(false)
        dialog.show()

        Handler(Looper.getMainLooper()).postDelayed({
            dialog.dismiss()
            verifyCode(androidId, code, email!!)
        }, 500)
    }


}