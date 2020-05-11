package com.example.in_boxua.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.in_boxua.viewModels.GoodsViewModel
import com.example.in_boxua.adapters.GoodsAdapter
import com.example.in_boxua.adapters.PhotoAdapter
import com.example.in_boxua.R
import com.example.in_boxua.TestData

class CatalogFragment () : Fragment() {

    private val goodsViewModel by lazy { ViewModelProviders.of(this).get(GoodsViewModel::class.java)}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view  = inflater.inflate(R.layout.fragment_catalog,null)
        val openCategory: Button = view.findViewById(R.id.bt_categories)
        openCategory.setOnClickListener {
            val manager = (view.context as AppCompatActivity).supportFragmentManager
            manager
                .beginTransaction()
                .replace(
                    R.id.fl_fragment_container, CategoryFragment())
                .addToBackStack(CategoryFragment().tag)
                .commit()
        }
        initRecycler(view,TestData.getNews())

        return view
    }

    private fun initRecycler(view: View, newsList: List<String>){

        val news : RecyclerView = view.findViewById(R.id.rv_news)
        val listGoods : RecyclerView = view.findViewById(R.id.rv_list_goods)
        val photoAdapter = PhotoAdapter(newsList)
        news.layoutManager = LinearLayoutManager(context)
        news.adapter = photoAdapter
        listGoods.layoutManager = GridLayoutManager(context,2)

        goodsViewModel.getCatalogListGoods().observe(this, Observer {
            it?.let {
                val goodsAdapter = GoodsAdapter(it)
                listGoods.adapter = goodsAdapter
            }
        })

    }
}