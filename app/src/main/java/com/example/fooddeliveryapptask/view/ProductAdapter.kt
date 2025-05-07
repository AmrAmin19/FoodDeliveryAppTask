package com.example.fooddeliveryapptask.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddeliveryapptask.databinding.ProductItemBinding
import com.example.fooddeliveryapptask.model.Product


class ProductAdapter(private var list: List<Product>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    class ViewHolder(val binding: ProductItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ProductItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    fun updateList(newList: List<Product>) {
        list = newList
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = list[position]
        holder.binding.title.text = product.name
        holder.binding.priceTextView.text = product.price

//        val imageName = "burger2"  // this is the name of the drawable (without the extension)
        val context = holder.itemView.context
        val resId = context.resources.getIdentifier(product.image, "drawable", context.packageName)
        holder.binding.ProductImageView.setImageResource(resId)

    }
}
