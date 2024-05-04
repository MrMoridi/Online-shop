package com.example.onlineshop.fragment.bottomNav

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.onlineshop.R
import com.example.onlineshop.databinding.FragmentHomeBinding
import com.example.onlineshop.databinding.FragmentProfileBinding
import com.example.onlineshop.databinding.FragmentShopCartBinding
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

        return binding.root

    }
}