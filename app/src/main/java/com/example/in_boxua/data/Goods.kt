package com.example.in_boxua.data

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableDouble
import androidx.databinding.ObservableInt

data class Goods(
    val title: String?,
    val price: Double?,
    val description: String?,
    val sizeLIst: List<SizeElement>,
    val photos: List<String>
){
    val mainPhoto = photos[0]
    var quantity : ObservableInt = ObservableInt(1)
    var obsPrice : ObservableDouble = ObservableDouble(price!!)
    var isFavorites : ObservableBoolean = ObservableBoolean(false)

}
