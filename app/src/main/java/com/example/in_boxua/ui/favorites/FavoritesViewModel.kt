package com.example.in_boxua.ui.favorites

import androidx.lifecycle.ViewModel
import com.example.in_boxua.data.Goods
import com.example.in_boxua.data.GoodsRepository

class FavoritesViewModel(private val goodsRepository: GoodsRepository)
    : ViewModel() {

    fun getGoods() = goodsRepository.getGoods()

    fun addGoods(goods: Goods) = goodsRepository.addGoods(goods)
}