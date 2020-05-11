package com.example.in_boxua.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.in_boxua.AdapterUpdates
import com.example.in_boxua.DataSingleton
import com.example.in_boxua.Goods
import com.example.in_boxua.TestData

class FavoritesViewModel : ViewModel() {

    private var favoritesGoodsList : MutableLiveData<ArrayList<Goods>> = MutableLiveData()

    fun getFavoritesGoods() = favoritesGoodsList

    init {
        favoritesGoodsList.value = DataSingleton.favoritesGoods
    }
}