package com.example.fooddeliveryapptask.viewModel

import androidx.lifecycle.ViewModel
import com.example.fooddeliveryapptask.model.Irepo
import com.example.fooddeliveryapptask.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel (val repo:Irepo) :ViewModel() {

    private val _foodList= MutableStateFlow<List<Product>>(emptyList())
    val foodList : StateFlow<List<Product>> = _foodList

    fun getProductsByCategory(category: String) {
        _foodList.value = repo.getProductsByCategory(category)
    }
}