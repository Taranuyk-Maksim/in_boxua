package com.example.in_boxua.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.in_boxua.*
import com.example.in_boxua.adapters.GoodsAdapter
import com.example.in_boxua.data.Goods
import com.example.in_boxua.utils.FavoritesCallback
import com.example.in_boxua.utils.InjectorUtils

class FavoritesFragment : Fragment(){

    private val factory = InjectorUtils.provideFavoritesGoodsViewModelFactory()
    private val  viewModel by lazy {ViewModelProviders.of(this,factory).get(FavoritesViewModel::class.java)}

    private val favoriteAdapter = GoodsAdapter(Actions())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_favorites,null)

//        if(DataSingleton.favoritesGoods.isNotEmpty()){
//            val status : TextView = view.findViewById(R.id.tv_empty_favorites)
//            status.visibility = View.GONE
//            initRecycler(view)
//        }
      //  addTest()

        initRecycler(view)
        return view
    }

    fun addTest() {
        for(g in TestData.getGoodsList()) {
            viewModel.addToFavorites(g)
        }
    }
    private fun initRecycler(view: View){

        val favorites : RecyclerView = view.findViewById(R.id.rv_favorites)

        favorites.layoutManager = GridLayoutManager(context,2)
        favorites.adapter = favoriteAdapter
        viewModel.getFavoritesGoods().observe(this, Observer {
            it?.let {

                favoriteAdapter.setGoodsList(it)

            }
        })
    }

    inner class Actions : FavoritesCallback {
        override fun addFavorite(goods: Goods) {
            viewModel.addToFavorites(goods)
        }

        override fun removeFavorite(goods: Goods) {
            viewModel.removeFavorite(goods)
        }

    }
}