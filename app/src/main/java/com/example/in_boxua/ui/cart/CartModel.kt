package com.example.in_boxua.ui.cart

import androidx.databinding.ObservableDouble
import androidx.lifecycle.ViewModelProviders
import com.example.in_boxua.data.Goods
import com.example.in_boxua.ui.favorites.FavoritesViewModel
import com.example.in_boxua.utils.*

class CartModel(private var viewModel: CartViewModel) : CartCallback {

    override fun addToCart(goods: Goods) {
        viewModel.addToCart(goods)
    }

    override fun remove(goods: Goods) {
        viewModel.remove(goods)
    }

    fun calcSum(list: List<Goods>) {
        var sum : Double = 0.0

        for (g in list) {
            sum += + g.obsPrice.get()
        }
        DataSingleton.sumAllGoodsInCart.set(sum)
    }

}