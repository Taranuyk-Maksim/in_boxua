package com.example.in_boxua

import androidx.annotation.DrawableRes
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableDouble
import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel

data class Goods(
    val id : Int,
    val title: String?,
    val price: Double?,
    val description: String?,
    val sizeLIst: List<SizeElement>,
    val photos: List<String>
){

    var quantity : ObservableInt = ObservableInt(1)
    var obsPrice : ObservableDouble = ObservableDouble(price!!)
    var isFavorites : ObservableBoolean = ObservableBoolean(false)
    //тут это не нужно, куда-то убрать
    var currency = " грн"




}
