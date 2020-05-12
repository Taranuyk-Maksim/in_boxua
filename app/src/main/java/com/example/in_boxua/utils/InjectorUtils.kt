package com.example.in_boxua.utils

import com.example.in_boxua.data.FakeDatabase
import com.example.in_boxua.data.GoodsRepository
import com.example.in_boxua.ui.CatalogViewModelFactory

object InjectorUtils {

    fun provideGoodsViewModelFactory(): CatalogViewModelFactory {
        val quoteRepository = GoodsRepository.getInstance(FakeDatabase.getInstance().goodsDao)
        return CatalogViewModelFactory(quoteRepository)
    }
}