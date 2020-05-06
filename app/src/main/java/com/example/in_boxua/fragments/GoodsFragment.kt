package com.example.in_boxua.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.in_boxua.*
import com.example.in_boxua.adapters.GoodsAdapter
import com.example.in_boxua.adapters.PhotoAdapter
import com.example.in_boxua.adapters.SizeElementAdapter

class GoodsFragment(val goods: Goods, val recommendList : List<Goods>) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_goods,null)

        initRecycler(view,goods.photos,recommendList,goods.sizeLIst)

        return view
    }

    private fun initRecycler(view: View, listPhotos: List<Int>,
                             listRecommendGoods : List<Goods>,
                             listSizes : List<String>){

        val sizes : RecyclerView = view.findViewById(R.id.rv_sizes)
        val photos : RecyclerView = view.findViewById(R.id.rv_photos)

        val recommend : RecyclerView = view.findViewById(R.id.rv_recomend)
        recommend.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        recommend.adapter =
            GoodsAdapter(listRecommendGoods)

        sizes.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        photos.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)

        recommend.adapter =
            GoodsAdapter(listRecommendGoods)
        sizes.adapter =
            SizeElementAdapter(listSizes)
        photos.adapter = PhotoAdapter(listPhotos)
    }
}