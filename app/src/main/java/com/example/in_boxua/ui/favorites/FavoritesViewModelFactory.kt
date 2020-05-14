package com.example.in_boxua.ui.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.in_boxua.data.GoodsRepository
import com.example.in_boxua.ui.catalog.CatalogViewModel

class FavoritesViewModelFactory(private val quoteRepository: GoodsRepository): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FavoritesViewModel(quoteRepository) as T
    }
}