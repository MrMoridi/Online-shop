package com.example.onlineshop.activity

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.R
import com.example.onlineshop.databinding.ActivityCartBinding
import com.example.onlineshop.recyclerView.DataProductsSimilar
import com.example.onlineshop.recyclerView.RecyclerSimilar

class CartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCartBinding
    private val dataSimilar = arrayOf(
        DataProductsSimilar(
            1,
            "پیرهن مردانه ال دی",
            "2,000,000",
            "3,000,000",
            R.drawable.img_shirt1
        ),
        DataProductsSimilar(
            2,
            "مانتو بافت زنانه اس ام",
            "1,000,000",
            "2,000,000",
            R.drawable.img_shirt5
        ),
        DataProductsSimilar(
            3,
            "مانتو بافت زنانه اچ دی",
            "3,000,000",
            "3,600,000",
            R.drawable.img_shirt3
        ),
        DataProductsSimilar(
            4,
            "مانتو بافت زنانه اچ ام",
            "6,000,000",
            "8,760,000",
            R.drawable.img_shirt4
        )

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setClickItem()
        setNumber()
        setRecycler()
        edtEnabled()
        setItemCart()



    }

    private fun setItemCart() {
        val itemTitle = intent.getStringExtra("title")
        val itemImageId = intent.getIntExtra("img", R.drawable.img_shirt1)
        //null
        if (itemTitle != null) {
            binding.txtTitleItem.text = itemTitle
        }
        binding.imgRecyclerShop.setImageResource(itemImageId)
    }

    private fun edtEnabled() {
        binding.frameLayoutEdt.setOnClickListener {
            binding.edt.isEnabled = true
        }
    }


    private fun setSelectedTab(selectedFrame: Int) {
        // تابعی برای تنظیم پس‌زمینه و رنگ‌های متن
        val backDefault = ContextCompat.getDrawable(this, R.drawable.back_cart_detail)
        val backSelected = ContextCompat.getDrawable(this, R.drawable.item_select_back)
        val colorDefault = Color.parseColor("#6F6D6D")
        val colorSelected = Color.parseColor("#EF472C")

        // تنظیم پس‌زمینه پیش‌فرض
        binding.frameLayoutDetail.background = backDefault
        binding.frameLayoutComment.background = backDefault
        binding.frameLayoutProperty.background = backDefault
        binding.frameLayoutSimilar.background = backDefault

        // تنظیم رنگ‌های پیش‌فرض
        binding.txtDetail.setTextColor(colorDefault)
        binding.txtComment.setTextColor(colorDefault)
        binding.txtProperty.setTextColor(colorDefault)
        binding.txtSimilar.setTextColor(colorDefault)

        // تنظیم پس‌زمینه و رنگ انتخاب‌شده
        when (selectedFrame) {
            1 -> {
                binding.frameLayoutDetail.background = backSelected
                binding.txtDetail.setTextColor(colorSelected)
            }

            2 -> {
                binding.frameLayoutComment.background = backSelected
                binding.txtComment.setTextColor(colorSelected)
            }

            3 -> {
                binding.frameLayoutProperty.background = backSelected
                binding.txtProperty.setTextColor(colorSelected)
            }

            4 -> {
                binding.frameLayoutSimilar.background = backSelected
                binding.txtSimilar.setTextColor(colorSelected)
            }
        }
    }

    private fun setClickItem() {
        val tabViews = listOf(
            Pair(binding.frameLayoutDetail, 1),
            Pair(binding.frameLayoutComment, 2),
            Pair(binding.frameLayoutProperty, 3),
            Pair(binding.frameLayoutSimilar, 4)
        )

        for (tabView in tabViews) {
            val (view, tabNumber) = tabView
            view.setOnClickListener {
                setSelectedTab(tabNumber)
                updateVisibility(tabNumber)
            }
        }
    }

    private fun updateVisibility(selectedTab: Int) {
        val visibilityMap = mapOf(
            1 to Triple(View.VISIBLE, View.INVISIBLE, View.INVISIBLE),
            2 to Triple(View.INVISIBLE, View.VISIBLE, View.INVISIBLE),
            3 to Triple(View.INVISIBLE, View.INVISIBLE, View.VISIBLE),
            4 to Triple(View.INVISIBLE, View.INVISIBLE, View.INVISIBLE)
        )

        val (detailVisibility, propertyVisibility, commentVisibility) = visibilityMap[selectedTab]
            ?: return

        binding.viewDetail.visibility = detailVisibility
        binding.viewProperty.visibility = propertyVisibility
        binding.viewComment.visibility = commentVisibility
        binding.viewSimilar.visibility = if (selectedTab == 4) View.VISIBLE else View.INVISIBLE
    }

    private fun setNumber() {
        // مقدار اولیه با تبدیل ایمن
        val initialNumber = binding.txtNumber.text.toString().toIntOrNull()
            ?: 0  // اگر تبدیل موفق نبود، مقدار 0 استفاده می‌شود
        var currentNumber = initialNumber

// لیسنر کاهش عدد
        binding.frameLayoutDiff.setOnClickListener {
            if (currentNumber > 0) {  // اطمینان حاصل کنید که منفی نشود
                currentNumber -= 1
                binding.txtNumber.text = currentNumber.toString()  // به‌روزرسانی متن
            }
        }

// لیسنر افزایش عدد
        binding.frameLayoutPlus.setOnClickListener {
            currentNumber += 1  // افزایش
            binding.txtNumber.text = currentNumber.toString()  // به‌روزرسانی متن
        }
    }

    private fun setRecycler() {


        val adapter = RecyclerSimilar(this, dataSimilar)
        binding.recyclerView.layoutManager = LinearLayoutManager(
            this,
            RecyclerView.HORIZONTAL,
            true
        )
        binding.recyclerView.adapter = adapter
    }
}