package com.example.in_boxua.utils
import com.example.in_boxua.data.Goods
import dagger.Module

interface SumCalc{
    fun calcSum(list : List<Goods>)
}

interface RecyclerViewUpdater{
    fun removeItem()
}

interface FavoritesCallback {
    fun addFavorite(goods: Goods)
    fun removeFavorite(goods: Goods)
}

interface CartCallback {
    fun addToCart(goods: Goods)
    fun remove(goods: Goods)
}
