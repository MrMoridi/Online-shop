package com.example.onlineshop.fragment

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.R
import com.example.onlineshop.activity.CategoryActivity
import com.example.onlineshop.databinding.FragmentHomeBinding
import com.example.onlineshop.recyclerView.DataProductsBottom
import com.example.onlineshop.recyclerView.DataProductsCenter
import com.example.onlineshop.recyclerView.DataProductsTop
import com.example.onlineshop.recyclerView.RecyclerBottomMainActivity
import com.example.onlineshop.recyclerView.RecyclerCenterMainActivity
import com.example.onlineshop.recyclerView.RecyclerTopMainActivity

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    private val dataTop = arrayOf(
        DataProductsTop(
            1,
            "از ورزشت لذت ببر!",
            "تولید و عرضه انواع کفش های\n اسپرت در همه سایز ها",
            R.drawable.shoe
        ),
        DataProductsTop(
            2,
            "خرید اقساطی طولانی مدت",
            "معتبر ترین فروشگاه ایران ",
            R.drawable.img_shoe
        ),
        DataProductsTop(
            3,
            "کیفیت و ارزانی همزمان!",
            " خرید با ارزان ترین قیمت کشور",
            R.drawable.img_shirt1
        )

    )

    private val dataBottom = arrayOf(
        DataProductsBottom(
            1,
            "پیرهن مردانه ال دی",
            "2,000,000",
            "3,000,000",
            R.drawable.img_shirt1
        ),
        DataProductsBottom(
            2,
            "مانتو بافت زنانه اس ام",
            "1,000,000",
            "2,000,000",
            R.drawable.img_shirt5
        ),
        DataProductsBottom(
            3,
            "مانتو بافت زنانه اچ دی",
            "3,000,000",
            "3,600,000",
            R.drawable.img_shirt3
        ),
        DataProductsBottom(
            4,
            "مانتو بافت زنانه اچ ام",
            "6,000,000",
            "8,760,000",
            R.drawable.img_shirt4
        )

    )

    private val dataCenter = arrayOf(
        DataProductsCenter(1, "دخترانه", R.drawable.category_baby_dress),
        DataProductsCenter(2, "بچگانه", R.drawable.category_onesie),
        DataProductsCenter(3, "مردانه", R.drawable.category_polo),
        DataProductsCenter(3, "پسرانه", R.drawable.category_tshirt),
        DataProductsCenter(3, "زنانه", R.drawable.category_woman),
        DataProductsCenter(4, "کفش", R.drawable.category_shoes)

    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        binding = FragmentHomeBinding.inflate(inflater)
        setRecyclerTop()
        clickNextOrPrevious()
        setRecyclerBottom()
        setRecyclerCenter()
        startActivityNext()

binding.searchView.setOnClickListener {
    binding.editTextSearch.isEnabled = true
}


        return binding.root
    }



    private fun startActivityNext() {
        binding.textView.setOnClickListener {
            val intent = Intent(requireContext(), CategoryActivity::class.java)
            startActivity(intent)
        }
    }

    private fun clickNextOrPrevious() {
        val layoutManager = binding.recyclerViewTop.layoutManager as LinearLayoutManager
        val recyclerView = binding.recyclerViewTop

        binding.btnNext.setOnClickListener {
            val currentPosition = layoutManager.findFirstVisibleItemPosition()
            recyclerView.smoothScrollToPosition(currentPosition + 1)
        }

        binding.btnPrevious.setOnClickListener {
            val currentPosition = layoutManager.findFirstVisibleItemPosition()
            recyclerView.smoothScrollToPosition(currentPosition - 1)
        }
    }

    private fun setRecyclerTop() {
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(binding.recyclerViewTop)

        val adapter = RecyclerTopMainActivity(requireActivity(), dataTop)
        binding.recyclerViewTop.layoutManager = LinearLayoutManager(
            requireActivity(),
            RecyclerView.HORIZONTAL,
            false
        )
        binding.recyclerViewTop.adapter = adapter
    }

    private fun setRecyclerBottom() {


        val adapter = RecyclerBottomMainActivity(requireActivity(), dataBottom)
        binding.recyclerViewBottom.layoutManager = LinearLayoutManager(
            requireActivity(),
            RecyclerView.HORIZONTAL,
            true
        )
        binding.recyclerViewBottom.adapter = adapter
    }

    private fun setRecyclerCenter() {


        val adapter = RecyclerCenterMainActivity(requireActivity(), dataCenter)
        binding.recyclerViewCenter.layoutManager = LinearLayoutManager(
            requireActivity(),
            RecyclerView.HORIZONTAL,
            true
        )
        binding.recyclerViewCenter.adapter = adapter
    }


}