package com.example.in_boxua

interface Presser{
    fun onPress()
}

interface AdapterUpdates{
    fun toUpdate()
}

interface SavesToCart{
    fun toCart()
}

interface AddsToFavorites {
    fun toFavorite(isFavorites : Boolean)
}
