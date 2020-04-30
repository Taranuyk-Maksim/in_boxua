package com.example.in_boxua

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_catalog)
        val rw : RecyclerView = findViewById(R.id.rv_list_goods)
       // val rv : RecyclerView = findViewById(R.id.rw_recomend)
//        rv.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rw.layoutManager = GridLayoutManager(this,2)

//        val list : ArrayList<Int> = ArrayList()
//        list.add(R.drawable.snekers_photo)
//        list.add(R.drawable.snekers_photo)
//        list.add(R.drawable.snekers_photo)
//        list.add(R.drawable.snekers_photo)
//        list.add(R.drawable.snekers_photo)
//        list.add(R.drawable.snekers_photo)
//        list.add(R.drawable.snekers_photo)

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
        list2.add(GoodsView("fdskljf f dsfjds fdsjk","500"))
        list2.add(GoodsView("fdskljf f dsfjds fdsjk","500"))
        list2.add(GoodsView("fdskljf f dsfjds fdsjk","500"))
        list2.add(GoodsView("fdskljf f dsfjds fdsjk","500"))


      //  rv.adapter = GoodsAdapter(list2)
        rw.adapter = GoodsAdapter(list2)
    }
}
