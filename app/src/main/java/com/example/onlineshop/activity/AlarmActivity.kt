package com.example.onlineshop.activity

import android.app.Activity
import android.app.Dialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.onlineshop.R
import com.example.onlineshop.databinding.ActivityAlarmBinding
import com.example.onlineshop.fragment.item.ReadFragment
import com.example.onlineshop.fragment.item.UnreadFragment

class AlarmActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAlarmBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlarmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        selectReadAndUnRead()
        setFragment()
        replaceFragment(UnreadFragment())
        binding.imgProfile.setOnClickListener {
            customDialog(this)
        }

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

    private fun setFragment() {
        binding.frameLayoutUnread.setOnClickListener { replaceFragment(UnreadFragment()) }
        binding.frameLayoutRead.setOnClickListener { replaceFragment(ReadFragment()) }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerViewAlarm, fragment)
            .commit()
    }

    private fun selectReadAndUnRead() {
        binding.frameLayoutRead.setOnClickListener {
            binding.read.visibility = View.VISIBLE
            binding.unread.visibility = View.INVISIBLE
        }
        binding.frameLayoutUnread.setOnClickListener {
            binding.read.visibility = View.INVISIBLE
            binding.unread.visibility = View.VISIBLE
        }
    }
}