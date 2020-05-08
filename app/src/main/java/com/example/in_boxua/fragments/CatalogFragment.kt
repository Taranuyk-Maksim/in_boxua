package com.example.in_boxua.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.in_boxua.Goods
import com.example.in_boxua.adapters.GoodsAdapter
import com.example.in_boxua.adapters.PhotoAdapter
import com.example.in_boxua.R

class CatalogFragment (private val newsList: List<String>, private val goodsList: List<Goods>) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view  = inflater.inflate(R.layout.fragment_catalog,null)

        initRecycler(view,newsList,goodsList)

        return view
    }

    private fun initRecycler(view: View, newsList: List<String>, goodsList : List<Goods>){
        val news : RecyclerView = view.findViewById(R.id.rv_new_goods)
        val listGoods : RecyclerView = view.findViewById(R.id.rv_list_goods)

        news.layoutManager = LinearLayoutManager(context)
        news.adapter =
            PhotoAdapter(newsList)

        listGoods.layoutManager = GridLayoutManager(context,2)
        listGoods.adapter =
            GoodsAdapter(goodsList)
    }
}