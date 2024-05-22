package com.example.onlineshop.recyclerView

import android.app.Activity
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.databinding.ListRecyclerFragmentMainActivityBinding

class RecyclerFragmentMainActivity(
    private val context: Activity,
    private val productsFragment: Array<DataProductsFragment>
) : RecyclerView.Adapter<RecyclerFragmentMainActivity.ProductFragmentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductFragmentViewHolder {
        val binding =
            ListRecyclerFragmentMainActivityBinding.inflate(context.layoutInflater, parent, false)
        return ProductFragmentViewHolder(binding)
    }

    override fun getItemCount(): Int = productsFragment.size

    override fun onBindViewHolder(
        holder: RecyclerFragmentMainActivity.ProductFragmentViewHolder,
        position: Int
    ) {
        holder.setData(productsFragment[position])


    }

    inner class ProductFragmentViewHolder(private val binding: ListRecyclerFragmentMainActivityBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setData(product: DataProductsFragment) {

            binding.txtTitle.text = product.title
            binding.txtPrice.text = product.txtPrice
            binding.txtPriceOld.text = product.txtPriceOld
            binding.imgProduct.setImageResource(product.imgAddress)


        }
    }


}