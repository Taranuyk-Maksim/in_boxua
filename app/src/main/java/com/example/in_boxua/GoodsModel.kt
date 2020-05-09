package com.example.in_boxua

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.in_boxua.fragments.GoodsFragment


class GoodsModel ()  {

    lateinit var presser : Presser
    lateinit var savesToCart: SavesToCart
    lateinit var savesToFavorites: AddsToFavorites
    lateinit var goods : Goods

    constructor(goods : Goods) : this(){
        this.goods = goods
    }

    constructor(goods : Goods,
                presser: Presser) : this(){
        this.goods = goods
        this.presser = presser
    }

    constructor(goods : Goods,
                savesToFavorites: AddsToFavorites) : this(){
        this.goods = goods
        this.savesToFavorites = savesToFavorites
    }


    fun addToCart(){
        savesToCart.toCart()
    }

    fun addToFavorite(){
        if(goods.isFavorites.get()){
            goods.isFavorites.set(false)
            savesToFavorites.toFavorite(false)
        }else{
            goods.isFavorites.set(true)
            savesToFavorites.toFavorite(true)
        }
    }
    //Button plas/minus quantity goods from cart
    fun goodsPlas() {
        goods.quantity.set(goods.quantity.get() + 1)
        goods.obsPrice.set(goods.obsPrice.get() + goods.price!!)
        presser.onPress()
    }

    fun goodsMinus() {
        if(goods.quantity.get()>1) {
            goods.quantity.set(goods.quantity.get() - 1)
            goods.obsPrice.set(goods.obsPrice.get() - goods.price!!)
            presser.onPress()
        }
    }


    fun open(view: View) {
        val manager = (view.context as AppCompatActivity).supportFragmentManager
        manager
            .beginTransaction()
            .replace(R.id.fl_fragment_container, GoodsFragment(goods,DataSingleton.recommendedGoods))
            .commit()
    }
}

