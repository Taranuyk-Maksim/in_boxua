package com.example.in_boxua

import android.util.Log
import android.view.View
import android.widget.ImageButton
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel

class Goods (
    val title: String,
    val price: Int,
    val description : String,
    val sizeLIst : List<String>,
    val photos : List<Int>
) : ViewModel(){

    var quantity : ObservableInt = ObservableInt(1)
    var obsPrice : ObservableInt = ObservableInt(price)
    var isFavorites : ObservableBoolean = ObservableBoolean(false)

    @DrawableRes val b = R.drawable.ic_favorite_border
    @DrawableRes val r = R.drawable.ic_favorite


}
