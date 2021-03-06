package com.example.in_boxua.ui.goods

import androidx.lifecycle.ViewModelProviders
import com.example.in_boxua.data.Goods
import com.example.in_boxua.ui.favorites.FavoritesViewModel
import com.example.in_boxua.utils.FavoritesCallback
import com.example.in_boxua.utils.InjectorUtils

class GoodsModel(private var viewModel: FavoritesViewModel) : FavoritesCallback {

    override fun addFavorite(goods: Goods) {
        viewModel.addToFavorites(goods)
    }

    override fun removeFavorite(goods: Goods) {
        viewModel.removeFavorite(goods)
    }

}