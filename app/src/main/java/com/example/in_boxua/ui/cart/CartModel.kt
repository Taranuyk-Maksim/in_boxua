package com.example.in_boxua.ui.cart

import androidx.lifecycle.ViewModelProviders
import com.example.in_boxua.data.Goods
import com.example.in_boxua.ui.favorites.FavoritesViewModel
import com.example.in_boxua.utils.CartCallback
import com.example.in_boxua.utils.FavoritesCallback
import com.example.in_boxua.utils.InjectorUtils

class CartModel(private var viewModel: CartViewModel) : CartCallback {

    override fun addToCart(goods: Goods) {
        viewModel.addToCart(goods)
    }

    override fun remove(goods: Goods) {
        viewModel.remove(goods)
    }

}