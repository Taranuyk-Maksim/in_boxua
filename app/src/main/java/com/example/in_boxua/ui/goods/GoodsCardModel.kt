package com.example.in_boxua.ui.goods
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.in_boxua.*
import com.example.in_boxua.data.Goods
import com.example.in_boxua.utils.FavoritesCallback
import com.example.in_boxua.utils.RecyclerViewUpdater
import com.example.in_boxua.utils.CartCallback

class GoodsCardModel() {

    private lateinit var cart: CartCallback
    private lateinit var updates: RecyclerViewUpdater
    private lateinit var favorite: FavoritesCallback

    private lateinit var goods : Goods

    fun setUpdater(updates: RecyclerViewUpdater) {
        this.updates = updates
    }
    fun setSavesToCard(savesToCart: CartCallback) {
        this.cart.toCart(goods)
    }
    fun setAddsToFavorite(savesToFavorites: FavoritesCallback) {
        this.favorite = savesToFavorites
    }
    fun getMainPhoto() = goods.photos[0]

    constructor(goods: Goods) : this(){
        this.goods = goods
    }

    var i = 0

    fun addToCart(){
        if (i++ <= 0){
            cart.toCart(goods)
        }
    }

    fun addToFavorite(){
        if(goods.isFavorites.get()){
            goods.isFavorites.set(false)
            favorite.addFavorite(goods)
            updates.removeItem()

        }else{
            goods.isFavorites.set(true)
            favorite.removeFavorite(goods)
        }
    }

    fun openGoodsPage(view: View) {
        val manager = (view.context as AppCompatActivity).supportFragmentManager
        manager
            .beginTransaction()
            .replace(
                R.id.fl_fragment_container,
                GoodsFragment(
                    goods,
                    TestData.getGoodsList()
                )
            )
          //  .addToBackStack(goods.id.toString())
            .commit()
    }
}
