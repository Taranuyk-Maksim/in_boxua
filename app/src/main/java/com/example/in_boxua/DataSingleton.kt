package com.example.in_boxua

import androidx.databinding.ObservableDouble
import androidx.lifecycle.MutableLiveData

object DataSingleton{

    val sumAllGoodsInCart = ObservableDouble()

    //Goods in cart
    var inCart : ArrayList<Goods> = ArrayList()

    //Favorites goods
    //private var favoritesGoodsList : MutableLiveData<List<Goods>> = MutableLiveData()

    //Recommend list
    var recommendedGoods : ArrayList<Goods> = ArrayList()

    val favoritesGoods : ArrayList<Goods> = ArrayList()

//    init {
//        favoritesGoodsList.value = TestData.getGoodsList() // TODO here must be favorite goods
//    }



}