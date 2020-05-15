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
import com.example.in_boxua.data.Goods
import com.example.in_boxua.databinding.FragmentCartBinding
import com.example.in_boxua.ui.catalog.CatalogViewModel
import com.example.in_boxua.utils.DataSingleton
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
//
//        if (DataSingleton.inCart.isEmpty()) {
//            val sumOrders : CardView = view.findViewById(R.id.cv_orders_sum)
//            sumOrders.visibility = View.GONE
//        } else {
//            val info : TextView = view.findViewById(R.id.tv_empty_box)
//            info.visibility = View.GONE
//
//        }

        initRecyclerInCart(view)
        return view
    }

    private fun initSum(goodsList: List<Goods>) {
        if (goodsList.isNotEmpty()) {
            var sum: Double = 0.0
            for (g in goodsList) {
                sum += g.obsPrice.get()
            }
            DataSingleton.sumAllGoodsInCart.set(sum)
        }
    }

    private fun initRecyclerInCart(view: View){
        val rvListGoods : RecyclerView = view.findViewById(R.id.rv_in_cart)
        //LinearLayoutManager not work!к
        rvListGoods.layoutManager = GridLayoutManager(context,1)

        viewModel.getCartList().observe(this, Observer {
            it?.let {
                if(it.isEmpty()){
                    val sumOrders : CardView = view.findViewById(R.id.cv_orders_sum)
                    sumOrders.visibility = View.GONE
                }else{
                    val goodsAdapter =
                        GoodsInCartAdapter(it)
                    rvListGoods.adapter = goodsAdapter
                }
                initSum(it)
            }
        })
    }
}
