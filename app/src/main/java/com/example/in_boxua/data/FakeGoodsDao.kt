package com.example.in_boxua.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeGoodsDao {
    private val goodsList = mutableListOf<Goods>()
    private val goodses = MutableLiveData<List<Goods>>()

    init {
        goodses.value = goodsList
    }

    fun addGoods(goods: Goods) {
        goodsList.add(goods)
        goodses.value = goodsList
    }

    fun getGoodses() = goodses as LiveData<List<Goods>>
}