package com.example.in_boxua.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.ObservableDouble
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.in_boxua.*
import com.example.in_boxua.adapters.GoodsFoCartAdapter

class CartFragment(var goodsList : ArrayList<Goods>) : Fragment() {


    val obsSum = ObservableDouble()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_cart,null)
        val text = view.findViewById<TextView>(R.id.tv_sum)
        text.text = obsSum.get().toString()
        initRecyclerInCart(view,goodsList)
        return view
    }


    private fun initRecyclerInCart(view: View, goods: List<Goods>?){
        val rvListGoods : RecyclerView = view.findViewById(R.id.rv_in_cart)
        //LinearLayout manager not work!к
        rvListGoods.layoutManager = GridLayoutManager(context,1)
        rvListGoods.adapter =
            GoodsFoCartAdapter(goods!!)

    }

}

