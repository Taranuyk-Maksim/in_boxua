package com.example.in_boxua.utils

import com.example.in_boxua.data.FakeDatabase
import com.example.in_boxua.data.GoodsRepository
import com.example.in_boxua.ui.cart.CartViewModelFactory
import com.example.in_boxua.ui.catalog.CatalogViewModelFactory
import com.example.in_boxua.ui.favorites.FavoritesViewModelFactory

object InjectorUtils {

    fun provideCatalogGoodsViewModelFactory(): CatalogViewModelFactory {
        val quoteRepository = GoodsRepository.getInstance(FakeDatabase.getInstance().goodsDao)
        return CatalogViewModelFactory(quoteRepository)
    }
    fun provideCartViewModelFactory(): CartViewModelFactory {
        val quoteRepository = GoodsRepository.getInstance(FakeDatabase.getInstance().goodsDao)
        return CartViewModelFactory(quoteRepository)
    }
    fun provideFavoritesGoodsViewModelFactory(): FavoritesViewModelFactory {
        val quoteRepository = GoodsRepository.getInstance(FakeDatabase.getInstance().goodsDao)
        return FavoritesViewModelFactory(quoteRepository)
    }
}