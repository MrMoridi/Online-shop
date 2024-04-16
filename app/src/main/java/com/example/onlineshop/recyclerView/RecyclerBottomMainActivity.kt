package com.example.onlineshop.recyclerView

import android.app.Activity
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.databinding.ListRecyclerBottomMainActivityBinding

class RecyclerBottomMainActivity(
    private val context: Activity,
    private val productsBottom: Array<DataProductsBottom>
) : RecyclerView.Adapter<RecyclerBottomMainActivity.ProductBottomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductBottomViewHolder {
        val binding = ListRecyclerBottomMainActivityBinding.inflate(context.layoutInflater,parent,false)
        return ProductBottomViewHolder(binding)
    }

    override fun getItemCount(): Int = productsBottom.size

    override fun onBindViewHolder(holder: RecyclerBottomMainActivity.ProductBottomViewHolder, position: Int) {
        holder.setData(productsBottom[position])


    }

    inner class ProductBottomViewHolder(private val binding: ListRecyclerBottomMainActivityBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setData(product: DataProductsBottom) {

            binding.txtTitle.text = product.title
            binding.txtPrice.text = product.txtPrice
            binding.txtPriceOld.text = product.txtPriceOld
            binding.imgProduct.setImageResource(product.imgAddress)



        }
    }


}