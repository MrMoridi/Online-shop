package com.example.onlineshop.recyclerView

import android.app.Activity
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.databinding.ListRecyclerExperBinding

class RecyclerExperience(
    private val context: Activity,
    private val productsExperience: Array<DataProductsExperience>
) : RecyclerView.Adapter<RecyclerExperience.ProductExperienceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductExperienceViewHolder {
        val binding = ListRecyclerExperBinding.inflate(context.layoutInflater, parent, false)
        return ProductExperienceViewHolder(binding)
    }

    override fun getItemCount(): Int = productsExperience.size

    override fun onBindViewHolder(
        holder: RecyclerExperience.ProductExperienceViewHolder,
        position: Int
    ) {
        holder.setData(productsExperience[position])


    }

    inner class ProductExperienceViewHolder(private val binding: ListRecyclerExperBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setData(product: DataProductsExperience) {

            binding.txtPrice.text = product.txtPrice
            binding.txtTitle.text = product.txtTitle
            binding.txtStar.text = product.txtStar
            binding.imgCategory.setImageResource(product.imgAddress)


        }
    }


}