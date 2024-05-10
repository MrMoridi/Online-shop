package com.example.onlineshop.fragment.bottomNav

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.onlineshop.R
import com.example.onlineshop.activity.AddressActivity
import com.example.onlineshop.activity.AlarmActivity
import com.example.onlineshop.activity.EditActivity
import com.example.onlineshop.activity.ExperienceActivity
import com.example.onlineshop.activity.FavoriteActivity
import com.example.onlineshop.activity.OrdersActivity
import com.example.onlineshop.activity.PasswordActivity
import com.example.onlineshop.databinding.FragmentProfileBinding
import de.hdodenhof.circleimageview.CircleImageView

class ProfileFragment: Fragment() {
    private lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater)

        // ایجاد یک شیء GradientDrawable
        val drawable = GradientDrawable()
// تنظیم شکل به دایره
        drawable.shape = GradientDrawable.OVAL
// تنظیم رنگ خط به سفید
        drawable.setStroke(4, Color.WHITE)

// ایجاد CircleImageView
        val circleImageView = CircleImageView(context)
// تنظیم تصویر مورد نظر
        circleImageView.setImageResource(R.drawable.profile)
// تنظیم اندازه و مکان دایره
        circleImageView.layoutParams = ViewGroup.LayoutParams(200, 200)
// تنظیم پس‌زمینه به GradientDrawable
        circleImageView.background = drawable

        binding.frameLayoutOrders.setOnClickListener { activityStart(OrdersActivity()) }
        binding.frameLayoutAlarm.setOnClickListener { activityStart(AlarmActivity()) }
        binding.frameLayoutAddress.setOnClickListener { activityStart(AddressActivity()) }
        binding.frameLayoutExper.setOnClickListener { activityStart(ExperienceActivity()) }
        binding.frameLayoutPassword.setOnClickListener { activityStart(PasswordActivity()) }
        binding.frameLayoutFavorite.setOnClickListener { activityStart(FavoriteActivity()) }

        binding.imgEdit.setOnClickListener {
            activityStart(EditActivity())
        }

        return binding.root

    }

    private fun activityStart(activity: Activity){
        startActivity(Intent(requireContext(),activity::class.java))
    }
}