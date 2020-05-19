package com.example.in_boxua.ui.cart

import com.example.in_boxua.utils.RecyclerViewUpdater
import com.example.in_boxua.utils.DataSingleton
import com.example.in_boxua.data.Goods
import com.example.in_boxua.utils.SumCalc

class GoodsInCartModel(private val goods : Goods,
                       private val updates: RecyclerViewUpdater,
                       private val sumCalc: SumCalc
) {

    //Button plas/minus quantity goods from cart
    fun goodsPlas() {
        goods.quantity.set(goods.quantity.get() + 1)
        goods.obsPrice.set(goods.obsPrice.get() + goods.price!!)
        sumCalc.calcSum()
    }

    fun goodsMinus() {
        if(goods.quantity.get()>1) {
            goods.quantity.set(goods.quantity.get() - 1)
            goods.obsPrice.set(goods.obsPrice.get() - goods.price!!)
            sumCalc.calcSum()
        }
    }

    fun getFavoriteSize() : String {
        for (s in goods.sizeLIst){
            if (s.isPress.get()){
                return "XL"
            }
        }
        return "XX"
    }
}