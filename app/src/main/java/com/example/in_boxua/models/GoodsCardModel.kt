package com.example.in_boxua.models
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.in_boxua.*
import com.example.in_boxua.fragments.GoodsFragment

class GoodsCardModel() {
    private lateinit var goods : Goods
    lateinit var updates: AdapterUpdates

    fun setUpdater(updates: AdapterUpdates) {
        this.updates = updates
    }

    constructor(goods: Goods) : this(){
        this.goods = goods
    }
    var i = 0
    fun addToCart(){
        if (i++ <= 0){
            DataSingleton.inCart.add(goods)
        }
    }

    fun addToFavorite(){
        if(goods.isFavorites.get()){
            goods.isFavorites.set(false)
            DataSingleton.favoritesGoods.remove(goods)
            updates.removeItem()

        }else{
            goods.isFavorites.set(true)
            DataSingleton.favoritesGoods.add(goods)
           // updates.toUpdate()
        }
    }

    fun openGoodsPage(view: View) {
        val manager = (view.context as AppCompatActivity).supportFragmentManager
        manager
            .beginTransaction()
            .replace(
                R.id.fl_fragment_container, GoodsFragment(goods,
                    TestData.getGoodsList()
                ))
            .addToBackStack(goods.id.toString())
            .commit()
    }
}
