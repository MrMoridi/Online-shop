package com.example.onlineshop.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.onlineshop.R
import com.example.onlineshop.databinding.ActivityCategoryBinding
import com.example.onlineshop.fragment.top.BabyFragment
import com.example.onlineshop.fragment.top.OnesieFragment
import com.example.onlineshop.fragment.top.PoloFragment
import com.example.onlineshop.fragment.top.ShoeFragment
import com.example.onlineshop.fragment.top.TishirtFragment
import com.example.onlineshop.fragment.top.WomanTopFragment

class CategoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCategoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setFragment()

        binding.imgExit.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        selectColorItem()

    }

    private fun selectColorItem() {
        binding.imgWomanFragment.saturation = 1f
        binding.imgBabyFragment.saturation = 0f
        binding.imgBoyFragment.saturation = 0f
        binding.imgGirlFragment.saturation = 0f
        binding.imgPoloFragment.saturation = 0f
        binding.imgShoeFragment.saturation = 0f
        val imageViews = listOf(
            binding.imgWomanFragment,
            binding.imgBabyFragment,
            binding.imgBoyFragment,
            binding.imgGirlFragment,
            binding.imgPoloFragment,
            binding.imgShoeFragment
        )

        imageViews.forEachIndexed { index, imageView ->
            imageView.setOnClickListener {
                imageViews.forEachIndexed { innerIndex, innerImageView ->
                    innerImageView.saturation = if (innerIndex == index) 1f else 0f
                }
            }
        }
    }

    private fun setFragment() {
        //انتخاب پیشفرص فرگمنت خانه
        selectFragment(WomanTopFragment())

        binding.frameLayoutWoman.setOnClickListener { selectFragment(WomanTopFragment()) }
        binding.frameLayoutPolo.setOnClickListener { selectFragment(PoloFragment()) }
        binding.frameLayoutBaby.setOnClickListener { selectFragment(BabyFragment()) }
        binding.frameLayoutTishirt.setOnClickListener { selectFragment(TishirtFragment()) }
        binding.frameLayoutOnesie.setOnClickListener { selectFragment(OnesieFragment()) }
        binding.frameLayoutShoe.setOnClickListener { selectFragment(ShoeFragment()) }
    }

    private fun selectFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerViewTop, fragment)
            .commit()
    }
}