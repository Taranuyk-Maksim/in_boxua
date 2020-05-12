package com.example.in_boxua

import androidx.databinding.ObservableDouble
import com.example.in_boxua.data.Goods

object DataSingleton{

    val sumAllGoodsInCart = ObservableDouble()

    var inCart : ArrayList<Goods> = ArrayList()

    var recommendedGoods : ArrayList<Goods> = ArrayList()

    val favoritesGoods : ArrayList<Goods> = ArrayList()

}