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
import com.example.in_boxua.adapters.GoodsAdapter
import com.example.in_boxua.data.Goods
import com.example.in_boxua.utils.FavoritesCallback
import com.example.in_boxua.utils.InjectorUtils

class FavoritesFragment : Fragment(){

    private val factory = InjectorUtils.provideFavoritesGoodsViewModelFactory()
    private val  favViewModel by lazy {ViewModelProviders.of(this,factory).get(FavoritesViewModel::class.java)}
    private val favoriteAdapter = GoodsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_favorites,null)
        favViewModel.getFavoritesGoods().observe(viewLifecycleOwner, Observer {
            it?.let {
                if(it.isNotEmpty()){
                    val status : TextView = view.findViewById(R.id.tv_empty_favorites)
                    status.visibility = View.GONE
                    initRecycler(view)
                }
            }
        })
//        if(DataSingleton.favoritesGoods.isNotEmpty()){
//            val status : TextView = view.findViewById(R.id.tv_empty_favorites)
//            status.visibility = View.GONE
//            initRecycler(view)
//        }
      //  addTest()
        return view
    }

    fun addTest() {
        for(g in TestData.getGoodsList()) {
            favViewModel.addToFavorites(g)
        }
    }
    private fun initRecycler(view: View){

        val favorites : RecyclerView = view.findViewById(R.id.rv_favorites)
        val status : TextView = view.findViewById(R.id.tv_empty_favorites)

        favorites.layoutManager = GridLayoutManager(context,2)
        favorites.adapter = favoriteAdapter
        favViewModel.getFavoritesGoods().observe(viewLifecycleOwner, Observer {
            it?.let {
                    favoriteAdapter.setGoodsList(it)
            }
        })
    }

    inner class Actions : FavoritesCallback {
        override fun addFavorite(goods: Goods) {
            favViewModel.addToFavorites(goods)
        }

        override fun removeFavorite(goods: Goods) {
            favViewModel.removeFavorite(goods)
        }

    }
}