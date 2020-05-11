package com.example.in_boxua

interface SumCalc{
    fun calcSum()
}

interface AdapterUpdates{
    fun removeItem()
}

interface SavesToCart{
    fun toCart()
}

interface AddsToFavorites {
    fun toFavorite(isFavorites : Boolean)
}
