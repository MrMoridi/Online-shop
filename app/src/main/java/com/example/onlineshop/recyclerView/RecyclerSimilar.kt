package com.example.onlineshop.recyclerView

import android.app.Activity
import android.content.Intent
import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.activity.CartActivity
import com.example.onlineshop.databinding.ListRecyclerSimiarBinding

class RecyclerSimilar(
    private val context: Activity,
    private val productsSimilar: Array<DataProductsSimilar>
) : RecyclerView.Adapter<RecyclerSimilar.ProductSimilarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductSimilarViewHolder {
        val binding = ListRecyclerSimiarBinding.inflate(context.layoutInflater, parent, false)
        return ProductSimilarViewHolder(binding)
    }

    override fun getItemCount(): Int = productsSimilar.size

    override fun onBindViewHolder(holder: ProductSimilarViewHolder, position: Int) {
        val currentItem = productsSimilar[position]
        holder.setData(currentItem)

        // رفتن به سبد خرید
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, CartActivity::class.java)
            intent.putExtra("title", currentItem.title)
            intent.putExtra("img", currentItem.imgAddress)
            holder.itemView.context.startActivity(intent)
        }
    }

    inner class ProductSimilarViewHolder(private val binding: ListRecyclerSimiarBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setData(product: DataProductsSimilar) {

            binding.txtTitle.text = product.title
            binding.txtPrice.text = product.txtPrice
            binding.txtPriceOld.text = product.txtPriceOld
            binding.imgProduct.setImageResource(product.imgAddress)


        }
    }


}