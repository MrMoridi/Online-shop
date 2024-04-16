package com.example.onlineshop.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.onlineshop.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {
    private lateinit var binding:ActivityCategoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)


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
}