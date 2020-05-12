package com.example.in_boxua.ui.goods

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.in_boxua.*
import com.example.in_boxua.models.GoodsCardModel
import com.example.in_boxua.adapters.GoodsAdapter
import com.example.in_boxua.adapters.PhotoAdapter
import com.example.in_boxua.adapters.SizeElementAdapter
import com.example.in_boxua.data.Goods
import com.example.in_boxua.databinding.FragmentGoodsBinding

class GoodsFragment(val goods: Goods, private val recommendList : List<Goods>) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_goods,null)

        initRecycler(view,goods.photos,recommendList,goods.sizeLIst)

        val bind : FragmentGoodsBinding = FragmentGoodsBinding.bind(view)
        bind.goods = goods
        bind.handler = GoodsCardModel(goods)
        val backButton : ImageButton = view.findViewById(R.id.iv_back)

        backButton.setOnClickListener {
            val manager = (view.context as AppCompatActivity).supportFragmentManager
            manager.popBackStack()
        }

        return view
    }

    private fun initRecycler(view: View, listPhotos: List<String>,
                             listRecommendGoods : List<Goods>,
                             listSizes : List<SizeElement>){

        val sizes : RecyclerView = view.findViewById(R.id.rv_sizes)
        val photos : RecyclerView = view.findViewById(R.id.rv_photos)

        val recommend : RecyclerView = view.findViewById(R.id.rv_recomend)
        val recommendAdapter = GoodsAdapter(TestData.getGoodsList())

        recommend.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        recommend.adapter = recommendAdapter

        sizes.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        photos.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        recommend.adapter = GoodsAdapter(TestData.getGoodsList())

        sizes.adapter = SizeElementAdapter(listSizes)
        photos.adapter = PhotoAdapter(listPhotos)
    }
}