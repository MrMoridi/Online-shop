package com.example.onlineshop.fragment.item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.R
import com.example.onlineshop.databinding.FragmentAlarmReadBinding
import com.example.onlineshop.recyclerView.DataItemRead
import com.example.onlineshop.recyclerView.RecyclerReadMainActivity

class ReadFragment : Fragment(R.layout.fragment_alarm_read) {
    private lateinit var binding: FragmentAlarmReadBinding
    private val dataForRecycler = arrayOf(
        DataItemRead(
            1,
            "بازگشت وجه",
            R.drawable.alarm,
            "28 فروردین 1403",
            "بانک"
        ),
        DataItemRead(
            2,
            "پرداخت موفق",
            R.drawable.alarm,
            "26 فروردین 1403",
            "غرفه دار"
        ),
        DataItemRead(
            3,
            "پرداخت ناموفق",
            R.drawable.alarm,
            "19 اسفند 1402",
            "اپلیکیشن"
        )

    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        binding = FragmentAlarmReadBinding.inflate(inflater)
        setRecyclerBottom()

        return binding.root
    }
    private fun setRecyclerBottom() {


        val adapter = RecyclerReadMainActivity(requireActivity(), dataForRecycler)
        binding.recyclerViewRead.layoutManager = LinearLayoutManager(
            requireActivity(),
            RecyclerView.VERTICAL,
            false
        )
        binding.recyclerViewRead.adapter = adapter
    }
}