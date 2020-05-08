package com.example.in_boxua

import androidx.annotation.DrawableRes
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableDouble
import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel

class Goods(
    val title: String?,
    val price: Double?,
    val description: String?,
    val sizeLIst: List<String>,
    val photos: List<String>
) : ViewModel(){

    var quantity : ObservableInt = ObservableInt(1)
    var obsPrice : ObservableDouble = ObservableDouble(price!!)
    var isFavorites : ObservableBoolean = ObservableBoolean(false)
    var currency = " грн"

    //костиль
    var sumAllGoods: ObservableDouble = ObservableDouble()
    //конець костиля

    @DrawableRes val b = R.drawable.ic_favorite_border
    @DrawableRes val r = R.drawable.ic_favorite


}
