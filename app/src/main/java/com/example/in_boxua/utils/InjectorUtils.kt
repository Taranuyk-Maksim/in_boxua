package com.example.in_boxua.utils

import androidx.lifecycle.ViewModelProvider
import com.example.in_boxua.data.FakeDatabase
import com.example.in_boxua.data.GoodsRepository
import com.example.in_boxua.ui.ViewModelFactory

object InjectorUtils {

    fun provideGoodsViewModelFactory(): ViewModelFactory {
        val quoteRepository = GoodsRepository.getInstance(FakeDatabase.getInstance().goodsDao)
        return ViewModelFactory(quoteRepository)
    }
}