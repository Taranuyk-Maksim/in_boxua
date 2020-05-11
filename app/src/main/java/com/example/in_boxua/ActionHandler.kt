package com.example.in_boxua

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.in_boxua.fragments.GoodsFragment

class ActionHandler() {
    private lateinit var goods : Goods
    lateinit var updates: AdapterUpdates

    fun setUpdater(updates: AdapterUpdates) {
        this.updates = updates
    }

    constructor(goods: Goods) : this(){
        this.goods = goods
    }

    fun addToCart(){
        var i = 0
        if (i == 0){
            DataSingleton.inCart.add(goods)
            i++
        }

    }

    fun addToFavorite(){
        if(goods.isFavorites.get()){
            goods.isFavorites.set(false)
            DataSingleton.favoritesGoods.remove(goods)
            //updates.toUpdate()

        }else{
            goods.isFavorites.set(true)
            DataSingleton.favoritesGoods.add(goods)
           // updates.toUpdate()
        }
    }
    //Button plas/minus quantity goods from cart
    fun goodsPlas() {
        goods.quantity.set(goods.quantity.get() + 1)
        goods.obsPrice.set(goods.obsPrice.get() + goods.price!!)
      //  presser.onPress()
    }

    fun goodsMinus() {
        if(goods.quantity.get()>1) {
            goods.quantity.set(goods.quantity.get() - 1)
            goods.obsPrice.set(goods.obsPrice.get() - goods.price!!)
          //  presser.onPress()
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
    fun openGoodsPage(view: View) {
        val manager = (view.context as AppCompatActivity).supportFragmentManager
        manager
            .beginTransaction()
            .replace(R.id.fl_fragment_container, GoodsFragment(goods,TestData.getGoodsList()))
            .commit()
    }
}
