package com.example.fooddeliveryapptask.model

data class Product(
    val id : Int ,
    val name: String,
    val price: String,
    val category: String,
    val image: String,
    var isFavorited: Boolean = false,
    var  isAInCart: Boolean = false
)
