package com.example.in_boxua

import androidx.databinding.ObservableDouble

object DataSingleton{

    val sumAllGoodsInCart = ObservableDouble()

    //Goods in cart
    var inCart : ArrayList<Goods> = ArrayList()

    //Favorites goods
    var inFavorites : ArrayList<Goods> = ArrayList()

    //Recommend list
    var recommendedGoods : ArrayList<Goods> = ArrayList()


}