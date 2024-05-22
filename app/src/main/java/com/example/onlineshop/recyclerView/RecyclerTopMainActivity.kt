package com.example.onlineshop.recyclerView

import android.app.Activity
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.databinding.ListRecyclerTopMainActivityBinding

class RecyclerTopMainActivity(
    private val context: Activity,
    private val productsTop: Array<DataProductsTop>
) : RecyclerView.Adapter<RecyclerTopMainActivity.ProductTopViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductTopViewHolder {
        val binding =
            ListRecyclerTopMainActivityBinding.inflate(context.layoutInflater, parent, false)
        return ProductTopViewHolder(binding)
    }

    override fun getItemCount(): Int = productsTop.size

    override fun onBindViewHolder(holder: ProductTopViewHolder, position: Int) {
        holder.setData(productsTop[position])


    }

    inner class ProductTopViewHolder(private val binding: ListRecyclerTopMainActivityBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setData(product: DataProductsTop) {

            binding.txtTitle.text = product.title
            binding.produceProduct.text = product.description
            binding.imgProduct.setImageResource(product.imgAddress)


        }
    }


}