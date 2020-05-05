package com.example.in_boxua

import android.util.Log
import android.view.View
import android.widget.ImageButton
import androidx.databinding.ObservableInt

class GoodsModel (val goods: Goods) {

    fun addToFavorite(view : View){
        var ib = view.findViewById<ImageButton>(R.id.ib_add_to_favorite)
        if(goods.isFavorites.get()){
            goods.isFavorites.set(false)
            ib.setImageResource(R.drawable.ic_favorite_border)
        }else{
            goods.isFavorites.set(true)
            ib.setImageResource(R.drawable.ic_favorite)
        }
    }
    //Button plas/minus quantity goods from cart
    fun goodsPlas() {
        goods.quantity.set(goods.quantity.get() + 1)
        goods.obsPrice.set(goods.obsPrice.get() + goods.price)
    }

    fun goodsMinus() {
        if(goods.quantity.get()>1) {
            goods.quantity.set(goods.quantity.get() - 1)
            goods.obsPrice.set(goods.obsPrice.get() - goods.price)
        }
    }

}