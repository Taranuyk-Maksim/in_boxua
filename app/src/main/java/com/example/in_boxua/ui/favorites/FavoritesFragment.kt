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
import com.example.in_boxua.viewModels.FavoritesViewModel

class FavoritesFragment : Fragment() {

    private val favoritesGoodsVIewModel by lazy { ViewModelProviders.of(this).get(FavoritesViewModel::class.java)}

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

        favoritesGoodsVIewModel.getFavoritesGoods().observe(this, Observer {
            it?.let {
                val favoritesAdapter = GoodsAdapter(it)
                favorites.adapter = favoritesAdapter

            }
        })
    }
}