package com.example.in_boxua

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ObservableInt
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FavoritesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val listR : ArrayList<Goods> = ArrayList()
        listR.add(Goods("fdslfjsdf ffdsf f :" , 200))
        listR.add(Goods("fdslfjsdf ffdsf f :" , 200))
        listR.add(Goods("fdslfjsdf ffdsf f :" , 200))
        listR.add(Goods("fdslfjsdf ffdsf f :" , 200))
        listR.add(Goods("fdslfjsdf ffdsf f :" , 200))
        listR.add(Goods("fdslfjsdf ffdsf f :" , 200))
        listR.add(Goods("fdslfjsdf ffdsf f :" , 200))

        val listP : ArrayList<Int> = ArrayList()
        listP.add(R.drawable.snekers_photo)
        listP.add(R.drawable.snekers_photo)
        listP.add(R.drawable.snekers_photo)
        listP.add(R.drawable.snekers_photo)
        listP.add(R.drawable.snekers_photo)

        val listS : ArrayList<String> = ArrayList()

        listS.add("xs")
        listS.add("s")
        listS.add("m")
        listS.add("l")
        listS.add("xl")
        listS.add("xxl")

        val view = inflater.inflate(R.layout.fragment_goods,null)

        initRecycler(view,listP,listR,listS)

        return view
    }

    private fun initRecycler(view: View, listPhotos: List<Int>,
                             listRecommendGoods : List<Goods>,
                             listSizes : List<String>){

        val sizes : RecyclerView = view.findViewById(R.id.rv_sizes)
        val photos : RecyclerView = view.findViewById(R.id.rv_photos)

        val recommend : RecyclerView = view.findViewById(R.id.rv_recomend)
        recommend.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        recommend.adapter = GoodsAdapter(listRecommendGoods)

        sizes.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        photos.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)

        recommend.adapter = GoodsAdapter(listRecommendGoods)
        sizes.adapter = SizeElementAdapter(listSizes)
        photos.adapter = PhotoAdapter(listPhotos)
    }
}