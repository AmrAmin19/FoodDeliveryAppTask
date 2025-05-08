package com.example.fooddeliveryapptask.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddeliveryapptask.R
import com.example.fooddeliveryapptask.databinding.ProductItemBinding
import com.example.fooddeliveryapptask.model.Product


class ProductAdapter(
    private var list: List<Product>,
    private var myListener:(Int)->Unit,
    ) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

        var cartCount:Int = 0

    class ViewHolder(val binding: ProductItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater: LayoutInflater =
            parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
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

      //  holder.binding.favoriteAddsButton.setImageResource( R.drawable.baseline_favorite_border_24)
        val icon = if (product.isFavorited) R.drawable.baseline_favorite_24 else R.drawable.baseline_favorite_border_24
        holder.binding.favoriteAddsButton.setImageResource(icon)
//        holder.binding.favoriteAddsButton.background.

      //  var isFavorited = false

        holder.binding.favoriteAddsButton.setOnClickListener {
           product.isFavorited = !product.isFavorited
            val icon = if (product.isFavorited) R.drawable.baseline_favorite_24 else R.drawable.baseline_favorite_border_24
            holder.binding.favoriteAddsButton.setImageResource(icon)
        }


        val background = if (product.isAInCart)
            ContextCompat.getDrawable(context, R.drawable.rounded_primary)
        else
            ContextCompat.getDrawable(context, R.drawable.rounded_white)

        holder.binding.cartButton.background = background

        holder.binding.cartButton.setOnClickListener {
            product.isAInCart = !product.isAInCart
            val background = if (product.isAInCart) {
                cartCount++
                myListener.invoke(cartCount)
                ContextCompat.getDrawable(context, R.drawable.rounded_primary)
            }
            else {
                cartCount--
                myListener.invoke(cartCount)
                ContextCompat.getDrawable(context, R.drawable.rounded_white)
            }

            holder.binding.cartButton.background = background
        }

    }



}
