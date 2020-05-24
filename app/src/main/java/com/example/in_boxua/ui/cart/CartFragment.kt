package com.example.in_boxua.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.in_boxua.*
import com.example.in_boxua.adapters.GoodsCartAdapter
import com.example.in_boxua.databinding.FragmentCartBinding
import com.example.in_boxua.utils.DataSingleton
import com.example.in_boxua.utils.InjectorUtils
import com.example.in_boxua.utils.SumCalc
import javax.inject.Inject

class CartFragment @Inject constructor(): Fragment(){

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
        initBinding(view)
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

    private fun initBinding(view : View) {
        FragmentCartBinding.bind(view)
    }

    private fun initRecycler(view: View){
        val rvListGoods : RecyclerView = view.findViewById(R.id.rv_in_cart)

        val goodsAdapter = GoodsCartAdapter(view,viewModel)

        rvListGoods.layoutManager = GridLayoutManager(context,1)

        rvListGoods.adapter = goodsAdapter
        viewModel.getCartList().observe(viewLifecycleOwner, Observer {
            it?.let {
                goodsAdapter.setGoodsList(it)
                goodsAdapter.calcSum()
            }
        })
    }
}
