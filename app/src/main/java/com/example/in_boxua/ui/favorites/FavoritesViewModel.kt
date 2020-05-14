package com.example.in_boxua.ui.favorites

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.in_boxua.utils.DataSingleton
import com.example.in_boxua.data.Goods
import com.example.in_boxua.data.GoodsRepository

class FavoritesViewModel (private val goodsRepository: GoodsRepository) : ViewModel() {

    fun getFavoritesGoods() = goodsRepository.getFavoritesList()

    fun addToFavorites(goods: Goods) = goodsRepository.addToFavorites(goods)

    fun removeFavorite(goods: Goods) = goodsRepository.removeFavoritesGoods(goods)
}