package com.example.in_boxua.data

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableDouble
import androidx.databinding.ObservableInt
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Goods(
    val title: String?,
    val price: Double,
    val description: String?,
    val sizeLIst: List<SizeElement>,
    val photos: List<String>
){
    @PrimaryKey
    var id : Int = 0
    val mainPhoto = photos.first()
    var quantity : ObservableInt = ObservableInt(1)
    var obsPrice : ObservableDouble = ObservableDouble(price)
    var isFavorites : ObservableBoolean = ObservableBoolean(false)
    var isInCart : ObservableBoolean = ObservableBoolean(false)
    var pinedSize : String = "XX"
}
