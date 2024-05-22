package com.example.onlineshop.fragment.top

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.R
import com.example.onlineshop.databinding.FragmentPoloBinding
import com.example.onlineshop.recyclerView.DataProductsFragment
import com.example.onlineshop.recyclerView.RecyclerFragmentMainActivity

class PoloFragment : Fragment() {
    private val dataFragment = arrayOf(
        DataProductsFragment(
            1,
            "پیرهن مردانه ال دی",
            "2,000,000",
            "3,000,000",
            R.drawable.img_shirt1
        ),
        DataProductsFragment(
            2,
            "مانتو بافت زنانه اس ام",
            "1,000,000",
            "2,000,000",
            R.drawable.img_shirt5
        ),
        DataProductsFragment(
            3,
            "مانتو بافت زنانه اچ دی",
            "3,000,000",
            "3,600,000",
            R.drawable.img_shirt3
        ),
        DataProductsFragment(
            4,
            "مانتو بافت زنانه اچ ام",
            "6,000,000",
            "8,760,000",
            R.drawable.img_shirt4
        )

    )

    private lateinit var binding: FragmentPoloBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPoloBinding.inflate(layoutInflater)
        setRecyclerFragment()
        return binding.root

    }

    private fun setRecyclerFragment() {


        val adapter = RecyclerFragmentMainActivity(requireActivity(), dataFragment)
        binding.recyclerViewFragment.layoutManager = LinearLayoutManager(
            requireActivity(),
            RecyclerView.HORIZONTAL,
            true
        )
        binding.recyclerViewFragment.adapter = adapter
    }

}