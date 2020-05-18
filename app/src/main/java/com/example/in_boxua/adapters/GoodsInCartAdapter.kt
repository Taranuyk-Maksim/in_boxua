package com.example.in_boxua.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.in_boxua.data.Goods
import com.example.in_boxua.ui.cart.GoodsInCartModel
import com.example.in_boxua.databinding.CardForCartBinding
import com.example.in_boxua.utils.RecyclerViewUpdater
import com.example.in_boxua.utils.DataSingleton
import com.example.in_boxua.utils.SumCalc

class GoodsInCartAdapter: RecyclerView.Adapter<GoodsInCartAdapter.GoodsHolder>() {
    private lateinit var listGoods: List<Goods>

    fun setGoodsList(listGoods: List<Goods>) {
        this.listGoods = listGoods
    }

    override fun getItemCount() : Int = listGoods.size

    private var itemPosition = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoodsHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding =  CardForCartBinding.inflate(inflater)
        return GoodsHolder(binding)
    }

    override fun onBindViewHolder(holder: GoodsHolder, position: Int) {
        holder.bind(listGoods[position])
        itemPosition = position
    }

    fun calcSum() : Double {
        var sum : Double = 0.0
        for (g in listGoods) {
            sum += g.obsPrice.get()
        }
        return sum
    }

    inner class GoodsHolder(private val binding: CardForCartBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: Goods){
            binding.goods = item
        }

        fun removeItem() {
            notifyItemRemoved(itemPosition)
        }


    }
}