package com.example.in_boxua

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_catalog.*

class CatalogFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val list2 : ArrayList<GoodsView> = ArrayList()
        list2.add(GoodsView("fdskljf f dsfjds fdsjk","500"))
        list2.add(GoodsView("fdskljf f dsfjds fdsjk","500"))
        list2.add(GoodsView("fdskljf f dsfjds fdsjk","500"))
        list2.add(GoodsView("fdskljf f dsfjds fdsjk","500"))
        list2.add(GoodsView("fdskljf f dsfjds fdsjk","500"))
        list2.add(GoodsView("fdskljf f dsfjds fdsjk","500"))
        list2.add(GoodsView("fdskljf f dsfjds fdsjk","500"))
        list2.add(GoodsView("fdskljf f dsfjds fdsjk","500"))
        list2.add(GoodsView("fdskljf f dsfjds fdsjk","500"))
        list2.add(GoodsView("fdskljf f dsfjds fdsjk","500"))
        list2.add(GoodsView("fdskljf f dsfjds fdsjk","500"))
        list2.add(GoodsView("fdskljf f dsfjds fdsjk","500"))
        list2.add(GoodsView("fdskljf f dsfjds fdsjk","500"))
        list2.add(GoodsView("fdskljf f dsfjds fdsjk","500"))

        val list1 : ArrayList<Int> = ArrayList()
        list1.add(R.drawable.snekers_photo)
        list1.add(R.drawable.snekers_photo)
        list1.add(R.drawable.snekers_photo)

        val view  = inflater.inflate(R.layout.fragment_catalog,null)

        initRecycler(view!!,list1,list2)


        return view
    }

    fun initRecycler(viewGroup: View, listGoods: List<Int>, listNewGoods : List<GoodsView>){
        val rvSpecialOffers : RecyclerView = viewGroup.findViewById(R.id.rv_new_goods)
        val rvListGoods : RecyclerView = viewGroup.findViewById(R.id.rv_list_goods)

        rvSpecialOffers.layoutManager = LinearLayoutManager(context)
        rvSpecialOffers.adapter = PhotoAdapter(listGoods)

        rvListGoods.layoutManager = GridLayoutManager(context,2)
        rvListGoods.adapter = GoodsAdapter(listNewGoods)
    }
}