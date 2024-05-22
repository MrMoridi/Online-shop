package com.example.onlineshop.recyclerView

import android.app.Activity
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.databinding.ListRecyclerCenterMainActivityBinding

class RecyclerCenterMainActivity(
    private val context: Activity,
    private val productsCenter: Array<DataProductsCenter>
) : RecyclerView.Adapter<RecyclerCenterMainActivity.ProductCenterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductCenterViewHolder {
        val binding =
            ListRecyclerCenterMainActivityBinding.inflate(context.layoutInflater, parent, false)
        return ProductCenterViewHolder(binding)
    }

    override fun getItemCount(): Int = productsCenter.size

    override fun onBindViewHolder(
        holder: RecyclerCenterMainActivity.ProductCenterViewHolder,
        position: Int
    ) {
        holder.setData(productsCenter[position])


    }

    inner class ProductCenterViewHolder(private val binding: ListRecyclerCenterMainActivityBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setData(product: DataProductsCenter) {

            binding.txtTitle.text = product.title
            binding.imgCategory.setImageResource(product.imgAddress)


        }
    }


}