package com.example.onlineshop.recyclerView

import android.app.Activity
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.databinding.ListRecyclerReadBinding

class RecyclerReadMainActivity(
    private val context: Activity,
    private val productsRead: Array<DataItemRead>
) : RecyclerView.Adapter<RecyclerReadMainActivity.ProductReadViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductReadViewHolder {
        val binding = ListRecyclerReadBinding.inflate(context.layoutInflater,parent,false)
        return ProductReadViewHolder(binding)
    }

    override fun getItemCount(): Int = productsRead.size

    override fun onBindViewHolder(holder: RecyclerReadMainActivity.ProductReadViewHolder, position: Int) {
        holder.setData(productsRead[position])


    }

    inner class ProductReadViewHolder(private val binding: ListRecyclerReadBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setData(product: DataItemRead) {

            binding.txtTitle.text = product.title
            binding.txtJob.text = product.job
            binding.txtDate.text = product.date
            binding.img.setImageResource(product.imgAddress)



        }
    }


}