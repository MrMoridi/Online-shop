package com.example.onlineshop.recyclerView

import android.app.Activity
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.databinding.ListRecyclerAddressBinding

class RecyclerAddress(
    private val context: Activity,
    private val productsAddress: Array<DataProductsAddress>
) : RecyclerView.Adapter<RecyclerAddress.ProductAddressViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAddressViewHolder {
        val binding = ListRecyclerAddressBinding.inflate(context.layoutInflater,parent,false)
        return ProductAddressViewHolder(binding)
    }

    override fun getItemCount(): Int = productsAddress.size

    override fun onBindViewHolder(holder: RecyclerAddress.ProductAddressViewHolder, position: Int) {
        holder.setData(productsAddress[position])


    }

    inner class ProductAddressViewHolder(private val binding: ListRecyclerAddressBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setData(product: DataProductsAddress) {

            binding.txtName.text = product.txtName
            binding.txtCode.text = product.txtCode
            binding.txtAddress.text = product.txtAddress
            binding.txtPhone.text = product.txtPhone



        }
    }


}