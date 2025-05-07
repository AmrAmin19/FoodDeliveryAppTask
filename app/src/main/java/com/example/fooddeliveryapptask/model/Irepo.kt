package com.example.fooddeliveryapptask.model

interface Irepo {
    fun getProductsByCategory(category: String): List<Product>
}