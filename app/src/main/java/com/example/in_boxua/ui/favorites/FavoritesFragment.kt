package com.example.in_boxua.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.in_boxua.*
import com.example.in_boxua.adapters.GoodsCatalogAdapter
import com.example.in_boxua.data.Goods
import com.example.in_boxua.utils.DataSingleton
import com.example.in_boxua.utils.FavoritesCallback
import com.example.in_boxua.utils.InjectorUtils

class FavoritesFragment : Fragment(), FavoritesCallback{

    private val factory = InjectorUtils.provideFavoritesGoodsViewModelFactory()
    private val  viewModel by lazy {ViewModelProviders.of(this,factory)
        .get(FavoritesViewModel::class.java)}
    private val favoriteAdapter = GoodsCatalogAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_favorites,null)

        if(DataSingleton.favoritesGoods.isNotEmpty()){
            val status : TextView = view.findViewById(R.id.tv_empty_favorites)
            status.visibility = View.GONE
            initRecycler(view)
        }

        return view
    }

    private fun initRecycler(view: View){

        val favorites : RecyclerView = view.findViewById(R.id.rv_favorites)

        favorites.layoutManager = GridLayoutManager(context,2)

        viewModel.getFavoritesGoods().observe(this, Observer {
            it?.let {
                favoriteAdapter.setViewModel(viewModel)
                favoriteAdapter.setGoodsList(it)
                favorites.adapter = favoriteAdapter
            }
        })
    }

    override fun addFavorite(goods: Goods) {
        viewModel.addToFavorites(goods)
    }

    override fun removeFavorite(goods: Goods) {
        viewModel.removeFavorite(goods)
    }
}