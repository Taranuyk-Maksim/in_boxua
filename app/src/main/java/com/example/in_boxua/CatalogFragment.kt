package com.example.in_boxua

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CatalogFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val list2 : ArrayList<Goods> = ArrayList()

        list2.add(Goods("fdslfjsdf ffdsf f :" , 200))
        list2.add(Goods("fdslfjsdf ffdsf f :" , 200))
        list2.add(Goods("fdslfjsdf ffdsf f :" , 200))
        list2.add(Goods("fdslfjsdf ffdsf f :" , 200))
        list2.add(Goods("fdslfjsdf ffdsf f :" , 200))
        list2.add(Goods("fdslfjsdf ffdsf f :" , 200))
        list2.add(Goods("fdslfjsdf ffdsf f :" , 200))
        list2.add(Goods("fdslfjsdf ffdsf f :" , 200))
        list2.add(Goods("fdslfjsdf ffdsf f :" , 200))
        list2.add(Goods("fdslfjsdf ffdsf f :" , 200))

        val list1 : ArrayList<Int> = ArrayList()
        list1.add(R.drawable.snekers_photo)
        list1.add(R.drawable.snekers_photo)
        list1.add(R.drawable.snekers_photo)

        val view  = inflater.inflate(R.layout.fragment_catalog,null)

        initRecycler(view,list1,list2)


        return view
    }

    private fun initRecycler(view: View, listGoods: List<Int>, listNewGoods : List<Goods>){
        val rvSpecialOffers : RecyclerView = view.findViewById(R.id.rv_new_goods)
        val rvListGoods : RecyclerView = view.findViewById(R.id.rv_list_goods)

        rvSpecialOffers.layoutManager = LinearLayoutManager(context)
        rvSpecialOffers.adapter = PhotoAdapter(listGoods)

        rvListGoods.layoutManager = GridLayoutManager(context,2)
        rvListGoods.adapter = GoodsAdapter(listNewGoods)
    }
}