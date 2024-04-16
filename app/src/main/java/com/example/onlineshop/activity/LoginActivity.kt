package com.example.onlineshop.activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.onlineshop.databinding.ActivityLoginBinding
import com.example.onlineshop.remote.RetrofitService
import com.example.onlineshop.remote.dataModel.DefaultModel
import com.example.onlineshop.remote.ext.ErrorUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onClickHandler()

    }


    private fun onClickHandler() {
        binding.btnSend.setOnClickListener {
            val email = binding.edtInputEmail.text.toString()
            if (email.isEmpty()) {
                binding.edtInputEmail.hint = "ایمیل شما نمیتواند خالی باشد"
                binding.edtInputEmail.setHintTextColor(Color.RED)

            } else {

                sendCodeEmail(email)
                val intent= Intent(this@LoginActivity, CodeLoginActivity::class.java)
                intent.putExtra("email",email)
                startActivity(intent)
                finish()

            }
        }
    }

    fun sendCodeEmail(email: String) {
        val service = RetrofitService.apiService

        CoroutineScope(Dispatchers.IO).launch {

            try {
                val response = service.sendCode(email)

                if (response.isSuccessful) {
                    launch(Dispatchers.Main) {
                        val data = response.body() as DefaultModel
                        Toast.makeText(this@LoginActivity, data.message, Toast.LENGTH_SHORT).show()
                    }
                } else {
                    launch(Dispatchers.Main) {
                        Toast.makeText(
                            this@LoginActivity,
                            ErrorUtils.getError(response),
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                }
            } catch (e: Exception) {
                Log.i("SERVER_ERROR", e.message.toString())
            }

        }
    }



}