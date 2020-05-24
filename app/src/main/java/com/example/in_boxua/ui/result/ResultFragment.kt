package com.example.in_boxua.ui.result

import com.example.in_boxua.ui.favorites.FavoriteModel
import com.example.in_boxua.ui.favorites.FavoritesViewModel
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
import com.example.in_boxua.utils.InjectorUtils

class ResultFragment(val list : List<Goods>) : Fragment(){

    private val factory = InjectorUtils.provideFavoritesGoodsViewModelFactory()
    private val  favViewModel by lazy {ViewModelProviders.of(this,factory).get(FavoritesViewModel::class.java)}


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_result,null)
        initRecycler(view)
        return view
    }

    private fun initRecycler(view: View){

        val favorites : RecyclerView = view.findViewById(R.id.rv_result)

        val favoriteAdapter = GoodsAdapter(FavoriteModel(favViewModel),view)
        favorites.layoutManager = GridLayoutManager(context,2)
        favorites.adapter = favoriteAdapter
        favoriteAdapter.setGoodsList(list)
    }
}