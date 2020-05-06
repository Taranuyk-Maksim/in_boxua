package com.example.in_boxua.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.in_boxua.*
import com.example.in_boxua.adapters.GoodsAdapter
import com.example.in_boxua.adapters.PhotoAdapter
import com.example.in_boxua.adapters.SizeElementAdapter

class FavoritesFragment (private val favoritesGoods: List<Goods>) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_favorites,null)

        initRecycler(view,favoritesGoods)

        return view
    }

    private fun initRecycler(view: View, goodsList : List<Goods>){

        val favorites : RecyclerView = view.findViewById(R.id.rv_favorites)
        favorites.layoutManager = GridLayoutManager(context,2)
        favorites.adapter = GoodsAdapter(goodsList)

    }
}