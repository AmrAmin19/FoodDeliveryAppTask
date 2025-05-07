package com.example.fooddeliveryapptask.model.RemoteData

import com.example.fooddeliveryapptask.model.Product
import com.example.fooddeliveryapptask.model.productList

class Remote : Iremote {

    override fun getProductsByCategory(category: String): List<Product> {
        return productList.filter { it.category.equals(category, ignoreCase = true) }
    }
}