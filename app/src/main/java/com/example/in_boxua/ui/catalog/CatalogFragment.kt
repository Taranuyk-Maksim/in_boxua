package com.example.in_boxua.ui.catalog

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
import com.example.in_boxua.R
import com.example.in_boxua.TestData
import com.example.in_boxua.adapters.GoodsAdapter
import com.example.in_boxua.ui.categories.CategoryFragment
import com.example.in_boxua.adapters.PhotoAdapter
import com.example.in_boxua.data.Goods
import com.example.in_boxua.ui.favorites.FavoritesViewModel
import com.example.in_boxua.utils.FavoritesCallback
import com.example.in_boxua.utils.InjectorUtils

class CatalogFragment : Fragment() {

    private val factory1 = InjectorUtils.provideCatalogGoodsViewModelFactory()
    private val  viewModel by lazy {ViewModelProviders.of(this,factory1)
        .get(CatalogViewModel::class.java)}

    private val factory = InjectorUtils.provideFavoritesGoodsViewModelFactory()
    private val  favViewModel by lazy { ViewModelProviders.of(this,factory).get(FavoritesViewModel::class.java)}

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
                    R.id.fl_fragment_container,
                    CategoryFragment()
                )
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
        val goodsAdapter = GoodsAdapter(CatalogModel(favViewModel), view)
        news.layoutManager = LinearLayoutManager(context)
        news.adapter = photoAdapter
        listGoods.layoutManager = GridLayoutManager(context,2)

        viewModel.getGoods().observe(viewLifecycleOwner, Observer {
            it?.let {
                goodsAdapter.setGoodsList(it)
                listGoods.adapter = goodsAdapter
            }
        })
    }

}