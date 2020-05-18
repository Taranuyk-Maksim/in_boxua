package com.example.in_boxua.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.in_boxua.*
import com.example.in_boxua.adapters.GoodsInCartAdapter
import com.example.in_boxua.utils.InjectorUtils

class CartFragment: Fragment(){

    private val factory = InjectorUtils.provideCartViewModelFactory()
    private val  viewModel by lazy {
        ViewModelProviders.of(this,factory).get(CartViewModel::class.java)}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_cart,null)
        val status : TextView = view.findViewById(R.id.tv_empty_cart)

        val sumOrders : CardView = view.findViewById(R.id.cv_orders_sum)
        viewModel.getCartList().observe(viewLifecycleOwner, Observer {
            it?.let {
                if(it.isNotEmpty()){
                    status.visibility = View.GONE
                    sumOrders.visibility = View.VISIBLE
                    initRecycler(view)
                } else {
                    status.visibility = View.VISIBLE
                    sumOrders.visibility = View.GONE
                }
            }
        })

        return view
    }


    private fun initRecycler(view: View){
        val rvListGoods : RecyclerView = view.findViewById(R.id.rv_in_cart)
        //LinearLayoutManager is not work!
        val sum : TextView = view.findViewById(R.id.tv_sum)
        rvListGoods.layoutManager = GridLayoutManager(context,1)

        val goodsAdapter = GoodsInCartAdapter(view)
        rvListGoods.adapter = goodsAdapter
        viewModel.getCartList().observe(viewLifecycleOwner, Observer {
            it?.let {
                goodsAdapter.setGoodsList(it)
                sum.text = goodsAdapter.calcSum().toString() + " грн"
            }
        })
    }
}
