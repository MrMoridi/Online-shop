package com.example.onlineshop.recyclerView

import android.app.Activity
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.databinding.ListRecyclerOrderMainActivityBinding

class RecyclerOrderMainActivity(
    private val context: Activity,
    private val productsOrder: Array<DataProductsOrder>
) : RecyclerView.Adapter<RecyclerOrderMainActivity.ProductOrderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductOrderViewHolder {
        val binding =
            ListRecyclerOrderMainActivityBinding.inflate(context.layoutInflater, parent, false)
        return ProductOrderViewHolder(binding)
    }

    override fun getItemCount(): Int = productsOrder.size

    override fun onBindViewHolder(
        holder: RecyclerOrderMainActivity.ProductOrderViewHolder,
        position: Int
    ) {
        holder.setData(productsOrder[position])


    }

    inner class ProductOrderViewHolder(private val binding: ListRecyclerOrderMainActivityBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setData(product: DataProductsOrder) {

            binding.txtTitle.text = product.title
            binding.txtCode.text = product.code
            binding.txtDate.text = product.date
            binding.txtPrice.text = product.txtPrice
            binding.txtPayment.text = product.payment
            binding.imgCategory.setImageResource(product.imgAddress)


        }
    }


}