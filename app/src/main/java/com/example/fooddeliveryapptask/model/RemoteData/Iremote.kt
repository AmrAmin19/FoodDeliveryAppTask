package com.example.fooddeliveryapptask.model.RemoteData

import com.example.fooddeliveryapptask.model.Product

interface Iremote {
    fun getProductsByCategory(category: String): List<Product>
}