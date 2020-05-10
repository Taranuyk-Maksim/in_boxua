package com.example.in_boxua

import android.view.View
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.in_boxua.fragments.GoodsFragment


class GoodsModel () : ViewModel() {

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
            .replace(R.id.fl_fragment_container, GoodsFragment(goods,TestData.getGoodsList()))
            .commit()
    }

    @DrawableRes
    val b = R.drawable.ic_favorite_border
    @DrawableRes
    val r = R.drawable.ic_favorite

    var goodsList : MutableLiveData<List<Goods>> = MutableLiveData()

    fun getListGoods() = goodsList
    init {
        goodsList.value = TestData.getGoodsList()
    }
}

