package com.example.in_boxua.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.in_boxua.GoodsModel
import com.example.in_boxua.adapters.GoodsAdapter
import com.example.in_boxua.adapters.PhotoAdapter
import com.example.in_boxua.R
import com.example.in_boxua.TestData

class CatalogFragment () : Fragment() {

    private val goodsViewModel by lazy { ViewModelProviders.of(this).get(GoodsModel::class.java)}
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view  = inflater.inflate(R.layout.fragment_catalog,null)

        initRecycler(view,TestData.getNews())

        return view
    }

    private fun initRecycler(view: View, newsList: List<String>){

        val news : RecyclerView = view.findViewById(R.id.rv_new_goods)
        val listGoods : RecyclerView = view.findViewById(R.id.rv_list_goods)

        val photoAdapter = PhotoAdapter(newsList)
        news.layoutManager = LinearLayoutManager(context)
        news.adapter = photoAdapter

        val goodsAdapter = GoodsAdapter()
        listGoods.layoutManager = GridLayoutManager(context,2)
        listGoods.adapter = goodsAdapter

        goodsViewModel.getListGoods().observe(this, Observer {
            it?.let {
                goodsAdapter.setGoodsList(it)
            }
        })

    }
}