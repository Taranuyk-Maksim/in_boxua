package com.example.in_boxua.models

import com.example.in_boxua.AdapterUpdates
import com.example.in_boxua.DataSingleton
import com.example.in_boxua.data.Goods
import com.example.in_boxua.SumCalc

class GoodsInCartModel(private val goods : Goods,
                       private val updates: AdapterUpdates,
                       private val sumCalc: SumCalc) {


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

    fun removeGoods(){
        DataSingleton.inCart.remove(goods)
        updates.removeItem()
    }
}