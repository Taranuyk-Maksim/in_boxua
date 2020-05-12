package com.example.in_boxua.ui.catalog

import androidx.lifecycle.ViewModel
import com.example.in_boxua.data.Goods
import com.example.in_boxua.data.GoodsRepository

class CatalogViewModel(private val goodsRepository: GoodsRepository)
    : ViewModel() {

    fun getGoods() = goodsRepository.getGoods()

    fun addGoods(goods: Goods) = goodsRepository.addGoods(goods)
}