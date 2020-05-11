package com.example.in_boxua

interface Presser{
    fun onPress()
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
