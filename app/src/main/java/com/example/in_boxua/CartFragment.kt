package com.example.in_boxua

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CartFragment(var goodsList : ArrayList<Goods>) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_cart,null)

        initRecyclerInCart(view,goodsList)
        return view
    }

    private fun initRecyclerInCart(view: View, goods: List<Goods>?){
        val rvListGoods : RecyclerView = view.findViewById(R.id.rv_in_cart)
        //LinearLayout manager not work!к
        rvListGoods.layoutManager = GridLayoutManager(context,1)
        rvListGoods.adapter = GoodsFoCartAdapter(goods!!)
    }

    private fun getSumPriceOrders() : Int{
        var sum = 0
        for(g in goodsList){
            sum += g.obsPrice.get()
        }
        return sum
    }
}
