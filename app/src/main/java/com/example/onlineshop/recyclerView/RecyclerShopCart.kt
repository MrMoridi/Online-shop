package com.example.onlineshop.recyclerView

import android.app.Activity
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.databinding.ListRecyclerShopCartBinding

class RecyclerShopCart(
    private val context: Activity,
    private val productsShopCart: Array<DataProductsShopCart>
) : RecyclerView.Adapter<RecyclerShopCart.ProductShopCartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductShopCartViewHolder {
        val binding = ListRecyclerShopCartBinding.inflate(context.layoutInflater,parent,false)
        return ProductShopCartViewHolder(binding)
    }

    override fun getItemCount(): Int = productsShopCart.size

    override fun onBindViewHolder(holder: RecyclerShopCart.ProductShopCartViewHolder, position: Int) {
        holder.setData(productsShopCart[position])


    }

    inner class ProductShopCartViewHolder(private val binding: ListRecyclerShopCartBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setData(product: DataProductsShopCart) {

            binding.txtTitle.text = product.txtTitle
            binding.txtPrice.text = product.txtPrice
            binding.imgCategory.setImageResource(product.imgAddress)




        }
    }


}