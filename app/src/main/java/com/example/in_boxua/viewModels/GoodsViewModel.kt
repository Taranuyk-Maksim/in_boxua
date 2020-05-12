package com.example.in_boxua.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.in_boxua.data.Goods
import com.example.in_boxua.TestData


class GoodsViewModel : ViewModel() {

    private var catalogGoodsList : MutableLiveData<List<Goods>> = MutableLiveData()

    fun getCatalogListGoods() = catalogGoodsList

    init {
        catalogGoodsList.value = TestData.getGoodsList()
    }
}

