package com.example.in_boxua.utils

import com.example.in_boxua.data.FakeDatabase
import com.example.in_boxua.data.GoodsRepository
import com.example.in_boxua.ui.cart.CartViewModelFactory
import com.example.in_boxua.ui.catalog.CatalogViewModelFactory
import com.example.in_boxua.ui.favorites.FavoritesViewModelFactory

object InjectorUtils {
    private val goodsRepository = GoodsRepository.getInstance(FakeDatabase.getInstance().goodsDao)

    fun provideCatalogGoodsViewModelFactory(): CatalogViewModelFactory {
        return CatalogViewModelFactory(goodsRepository)
    }
    fun provideCartViewModelFactory(): CartViewModelFactory {

        return CartViewModelFactory(goodsRepository)
    }
    fun provideFavoritesGoodsViewModelFactory(): FavoritesViewModelFactory {

        return FavoritesViewModelFactory(goodsRepository)
    }
}