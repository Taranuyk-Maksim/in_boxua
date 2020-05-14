package com.example.in_boxua.ui.catalog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.in_boxua.data.GoodsRepository

class CatalogViewModelFactory(private val quoteRepository: GoodsRepository): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CatalogViewModel(quoteRepository) as T
    }
}