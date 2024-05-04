package com.example.onlineshop.fragment.bottomNav

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.onlineshop.R
import com.example.onlineshop.activity.MainActivity
import com.example.onlineshop.databinding.FragmentCategoryBinding
import com.example.onlineshop.fragment.top.BabyFragment
import com.example.onlineshop.fragment.top.OnesieFragment
import com.example.onlineshop.fragment.top.PoloFragment
import com.example.onlineshop.fragment.top.ShoeFragment
import com.example.onlineshop.fragment.top.TishirtFragment
import com.example.onlineshop.fragment.top.WomanTopFragment

class CategoryFragment: Fragment() {
    private lateinit var binding: FragmentCategoryBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoryBinding.inflate(inflater)

        setFragment()

        return binding.root

    }

    private fun setFragment() {
        //انتخاب پیشفرص فرگمنت مرد
        selectFragment(PoloFragment())
        binding.imgWomanFragment.saturation = 0f
        binding.imgBabyFragment.saturation = 0f
        binding.imgBoyFragment.saturation = 0f
        binding.imgGirlFragment.saturation = 0f
        binding.imgManFragment.saturation = 1f
        binding.imgShoeFragment.saturation = 0f

        binding.frameLayoutWoman.setOnClickListener {
            binding.imgWomanFragment.saturation = 1f
            binding.imgBabyFragment.saturation = 0f
            binding.imgBoyFragment.saturation = 0f
            binding.imgGirlFragment.saturation = 0f
            binding.imgManFragment.saturation = 0f
            binding.imgShoeFragment.saturation = 0f
            selectFragment(WomanTopFragment())
        }
        binding.frameLayoutMan.setOnClickListener {
            binding.imgWomanFragment.saturation = 0f
            binding.imgBabyFragment.saturation = 0f
            binding.imgBoyFragment.saturation = 0f
            binding.imgGirlFragment.saturation = 0f
            binding.imgManFragment.saturation = 1f
            binding.imgShoeFragment.saturation = 0f
            selectFragment(PoloFragment())
        }
        binding.frameLayoutBaby.setOnClickListener {
            binding.imgWomanFragment.saturation = 0f
            binding.imgBabyFragment.saturation = 0f
            binding.imgBoyFragment.saturation = 0f
            binding.imgGirlFragment.saturation = 1f
            binding.imgManFragment.saturation = 0f
            binding.imgShoeFragment.saturation = 0f
            selectFragment(BabyFragment())
        }
        binding.frameLayoutTishirt.setOnClickListener {
            binding.imgWomanFragment.saturation = 0f
            binding.imgBabyFragment.saturation = 0f
            binding.imgBoyFragment.saturation = 1f
            binding.imgGirlFragment.saturation = 0f
            binding.imgManFragment.saturation = 0f
            binding.imgShoeFragment.saturation = 0f
            selectFragment(TishirtFragment())
        }
        binding.frameLayoutOnesie.setOnClickListener {
            binding.imgWomanFragment.saturation = 0f
            binding.imgBabyFragment.saturation = 1f
            binding.imgBoyFragment.saturation = 0f
            binding.imgGirlFragment.saturation = 0f
            binding.imgManFragment.saturation = 0f
            binding.imgShoeFragment.saturation = 0f
            selectFragment(OnesieFragment())
        }
        binding.frameLayoutShoe.setOnClickListener {
            binding.imgWomanFragment.saturation = 0f
            binding.imgBabyFragment.saturation = 0f
            binding.imgBoyFragment.saturation = 0f
            binding.imgGirlFragment.saturation = 0f
            binding.imgManFragment.saturation = 0f
            binding.imgShoeFragment.saturation = 1f
            selectFragment(ShoeFragment())
        }
    }

    private fun selectFragment(fragment: Fragment) {
        val transaction = childFragmentManager.beginTransaction()
        transaction
            .replace(R.id.fragmentContainerViewTop, fragment)
            .commit()
    }

}