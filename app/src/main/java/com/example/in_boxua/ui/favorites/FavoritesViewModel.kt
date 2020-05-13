package com.example.in_boxua.ui.favorites

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.in_boxua.utils.DataSingleton
import com.example.in_boxua.data.Goods

class FavoritesViewModel : ViewModel() {

    private var favoritesGoodsList : MutableLiveData<ArrayList<Goods>> = MutableLiveData()

    fun getFavoritesGoods() = favoritesGoodsList

    init {
        favoritesGoodsList.value = DataSingleton.favoritesGoods
    }
}