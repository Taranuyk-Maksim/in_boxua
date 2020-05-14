package com.example.in_boxua.ui.cart

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.in_boxua.utils.DataSingleton
import com.example.in_boxua.data.Goods
import com.example.in_boxua.data.GoodsRepository

class CartViewModel (private val goodsRepository: GoodsRepository) : ViewModel() {

    fun getCartList() = goodsRepository.getCartList()

    fun addToCart(goods: Goods) = goodsRepository.addToCart(goods)

    fun remove(goods: Goods) = goodsRepository.removeInCartGoods(goods)
}