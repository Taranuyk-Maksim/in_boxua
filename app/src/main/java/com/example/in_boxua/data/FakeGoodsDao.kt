package com.example.in_boxua.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.in_boxua.TestData

class FakeGoodsDao {
    private val goodsList = mutableListOf<Goods>()
    private val goodsListLiveData = MutableLiveData<List<Goods>>()

    private val goodsFavoriteList = mutableListOf<Goods>()
    private val goodsFavoritesLiveData = MutableLiveData<List<Goods>>()

    private val goodsCartList = mutableListOf<Goods>()
    private val goodsCartLiveData = MutableLiveData<List<Goods>>()

    init {
        goodsList.addAll(TestData.getCatalogGoods())
        goodsFavoritesLiveData.value = goodsFavoriteList
        goodsListLiveData.value = goodsList
        goodsCartLiveData.value = goodsCartList
    }

    //Add/get goods
    fun addGoods(goods: Goods) {
        goodsList.add(goods)
        goodsListLiveData.value = goodsList
    }
    fun getGoodsList () = goodsListLiveData as LiveData<List<Goods>>

    //add/remove/get in favorite
    fun addToFavorites(goods: Goods) {
        goodsFavoriteList.add(goods)
        goodsFavoritesLiveData.value = goodsFavoriteList
    }

    fun removeFavoriteGods(goods: Goods) {
        goodsFavoriteList.remove(goods)
        goodsFavoritesLiveData.value = goodsFavoriteList
    }

    fun getFavoritesList () = goodsFavoritesLiveData as LiveData<List<Goods>>

    //add/remove/get in cart
    fun addToCart(goods: Goods) {
        goodsCartList.add(goods)
        goodsCartLiveData.value = goodsCartList
    }

    fun removeInCartGods(goods: Goods) {
        goodsCartList.remove(goods)
        goodsCartLiveData.value = goodsCartList
    }

    fun getCartList () = goodsCartLiveData as LiveData<List<Goods>>


    //Start init example goods
    fun initE(){
        goodsList.addAll(TestData.getCatalogGoods())
    }


}