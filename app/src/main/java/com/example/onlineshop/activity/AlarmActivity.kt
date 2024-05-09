package com.example.onlineshop.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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