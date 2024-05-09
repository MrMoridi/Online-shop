package com.example.onlineshop.recyclerView

import android.app.Activity
import android.content.Intent
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.activity.CartActivity
import com.example.onlineshop.databinding.ListRecyclerFavoriteBinding
import com.example.onlineshop.fragment.bottomNav.ShopCartFragment

class RecyclerFavorite(
    private val context: Activity,
    private val productsFavorite: Array<DataProductsFavorite>
) : RecyclerView.Adapter<RecyclerFavorite.ProductFavoriteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductFavoriteViewHolder {
        val binding = ListRecyclerFavoriteBinding.inflate(context.layoutInflater,parent,false)
        return ProductFavoriteViewHolder(binding)
    }

    override fun getItemCount(): Int = productsFavorite.size

    override fun onBindViewHolder(holder: RecyclerFavorite.ProductFavoriteViewHolder, position: Int) {
        holder.setData(productsFavorite[position])

        //رفتن به سبد خرید بعد از کلیک بر روی هر ایتم ریسایکلر
        holder.itemView.setOnClickListener {
            val intent = Intent(context, CartActivity::class.java)
            intent.putExtra("id",productsFavorite[position].id)
            context.startActivity(intent)
        }


    }

    inner class ProductFavoriteViewHolder(private val binding: ListRecyclerFavoriteBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setData(product: DataProductsFavorite) {

            binding.txtTitle.text = product.title
            binding.txtPrice.text = product.txtPrice
            binding.txtPriceOld.text = product.txtPriceOld
            binding.imgProduct.setImageResource(product.imgAddress)



        }
    }


}