package com.example.in_boxua

import androidx.databinding.Bindable
import androidx.lifecycle.ViewModel

class GoodsView (
    val title: String,
    val price: String
) : ViewModel()  {

    @Bindable
    private fun setImage() {
    }

}
