package com.example.in_boxua.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.in_boxua.*
import com.example.in_boxua.adapters.GoodsFoCartAdapter
import com.example.in_boxua.databinding.FragmentCartBinding

class CartFragment() : Fragment(){

    var goodsList = DataSingleton.favorites
    val handler = Handler(goodsList)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_cart,null)

        initBinding(view)
        initRecyclerInCart(view,goodsList)
        initSum()
        return view
    }

    private fun initBinding(view : View) {
        val bind : FragmentCartBinding = FragmentCartBinding.bind(view)
        bind.setVariable(R.layout.fragment_cart,goodsList[0])
        bind.goods = goodsList[0]

    }

    private fun initSum() {
        var sum : Double = 0.0
        for (g in goodsList) {
            sum += g.obsPrice.get()
        }
        DataSingleton.sumAllGoodsInCart.set(sum)
    }

    private fun initRecyclerInCart(view: View, goods: List<Goods>?){
        val rvListGoods : RecyclerView = view.findViewById(R.id.rv_in_cart)
        //LinearLayout manager not work!к
        rvListGoods.layoutManager = GridLayoutManager(context,1)
        rvListGoods.adapter =
            GoodsFoCartAdapter(goods!!,handler)
    }


    class Handler(private val goodsList: ArrayList<Goods>) : Presser{

        override fun onPress() {
            var sum : Double = 0.0
            for (g in goodsList) {
                sum += g.obsPrice.get()
            }
            DataSingleton.sumAllGoodsInCart.set(sum)
        }
    }
}
