package com.example.in_boxua.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.in_boxua.TestData

class FakeGoodsDao {
    private val goodsList = mutableListOf<Goods>()
    private val goodsListCatalog = MutableLiveData<List<Goods>>()

    init {
        goodsList.addAll(TestData.getGoodsList())
        goodsListCatalog.value = goodsList
    }

    fun addGoods(goods: Goods) {
        goodsList.add(goods)
        goodsListCatalog.value = goodsList
    }

    fun getGoodsListCatalog () = goodsListCatalog as LiveData<List<Goods>>
}