package com.example.in_boxua

import android.util.Log
import android.view.View
import android.widget.ImageButton
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel

class Goods (
    val title: String,
    val price: Int,
    val sizeLIst : List<String>,
    val photos : List<Int>
) : ViewModel(){

    var quantity : ObservableInt = ObservableInt(1)
    var obsPrice : ObservableInt = ObservableInt(price)
    var isFavorites : ObservableBoolean = ObservableBoolean(false)


}
