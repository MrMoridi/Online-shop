package com.example.onlineshop.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.onlineshop.databinding.ActivityInformationBinding

class InformationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInformationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(this@InformationActivity, MainActivity::class.java)
        binding.btnSend.setOnClickListener {
            if (binding.edtInputUsername.text.isEmpty()) {
                binding.txtError.visibility = View.VISIBLE
            } else {
                val username = binding.edtInputUsername.text.toString()
                intent.putExtra("username", username)
                startActivity(intent)
                finish()
            }
        }
        binding.reject.setOnClickListener { startActivity(intent) }

    }


}