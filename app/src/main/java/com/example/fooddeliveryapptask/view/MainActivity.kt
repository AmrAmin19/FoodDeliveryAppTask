package com.example.fooddeliveryapptask.view

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.fooddeliveryapptask.R
import com.example.fooddeliveryapptask.databinding.ActivityMainBinding
import com.example.fooddeliveryapptask.model.Irepo
import com.example.fooddeliveryapptask.model.RemoteData.Remote
import com.example.fooddeliveryapptask.model.Repo
import com.example.fooddeliveryapptask.viewModel.MainFactory
import com.example.fooddeliveryapptask.viewModel.MainViewModel
import com.google.android.material.chip.Chip
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var mainFactory: MainFactory
    lateinit var viewModel: MainViewModel
    lateinit var  binding: ActivityMainBinding
    lateinit var productAdapter: ProductAdapter

//    private var category: String = "burger"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main)

        mainFactory = MainFactory(Repo.getInstance(Remote()))
        viewModel=ViewModelProvider(this,mainFactory)[MainViewModel::class.java]


        productAdapter = ProductAdapter(emptyList())
        binding.productsRecycel.adapter = productAdapter

        updateChips()
    //   viewModel.getProductsByCategory("burger")
//        Log.d("AmrTest", "list size = ${list.size} + ${list.first().name}")


        lifecycleScope.launch {
            viewModel.foodList.collect{
                productAdapter.updateList(it)
                Log.d("AmrTest", "list size = ${it.size} + ${it.first().name}")
            }
        }

    }


    fun updateChips(){

        binding.chip0.isChecked = true
        binding.chip0.setChipBackgroundColorResource(R.color.PrimaryColor)
        binding.chip0.setTextColor(Color.WHITE)
        Log.d("AmrChips", "chip0 selected ${binding.chip0.text}")
        viewModel.getProductsByCategory("burger")


        binding.chipGroup.setOnCheckedChangeListener { group, checkedId ->
            // If no chip is selected (checkedId is -1), re-select chip0
//            if (checkedId == -1) {
//                binding.chip0.isChecked = true
//                binding.chip0.chipBackgroundColor = ContextCompat.getColorStateList(requireContext(), R.color.colorPrimary)
//                Log.d("AmrChips", "chip0 re-selected")
//                viewModel.getFilterdProducts(null)
//            } else {
            // Reset all chips to their default background color
            for (i in 0 until group.childCount) {
                val chip = group.getChildAt(i) as Chip
                chip.setChipBackgroundColorResource(R.color.white) // Default color
                chip.setTextColor(Color.BLACK)
            }

            // Change the background color of the selected chip
            when (checkedId) {
                R.id.chip0 -> {
                    binding.chip0.setChipBackgroundColorResource(R.color.PrimaryColor)
                    binding.chip0.setTextColor(Color.WHITE)
                    Log.d("AmrChips", "chip0 selected ${binding.chip0.text}")
                    viewModel.getProductsByCategory("${binding.chip0.text}")
                }
                R.id.chip1 -> {
                    binding.chip1.setChipBackgroundColorResource(R.color.PrimaryColor)
                    binding.chip1.setTextColor(Color.WHITE)
                    Log.d("AmrChips", "chip1 selected ${binding.chip1.text}")
                    viewModel.getProductsByCategory("${binding.chip1.text}")
                }
                R.id.chip2 -> {
                    binding.chip2.setChipBackgroundColorResource(R.color.PrimaryColor)
                    binding.chip2.setTextColor(Color.WHITE)
                    Log.d("AmrChips", "chip2 selected ${binding.chip2.text}")
                    viewModel.getProductsByCategory("${binding.chip2.text}")
                }
                R.id.chip3 -> {
                    binding.chip3.setChipBackgroundColorResource(R.color.PrimaryColor)
                    binding.chip3.setTextColor(Color.WHITE)
                    Log.d("AmrChips", "chip3 selected ${binding.chip3.text}")
                    viewModel.getProductsByCategory("${binding.chip3.text}")
                }
            }
            //           }
        }
    }

}