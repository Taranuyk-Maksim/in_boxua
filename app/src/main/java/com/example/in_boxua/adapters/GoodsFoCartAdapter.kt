package com.example.in_boxua.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.in_boxua.Goods
import com.example.in_boxua.GoodsModel
import com.example.in_boxua.databinding.CartCardBinding

class GoodsFoCartAdapter(private val goods : List<Goods>) : RecyclerView.Adapter<GoodsFoCartAdapter.GoodsHolder>() {

    override fun getItemCount() : Int = goods.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoodsHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding =  CartCardBinding.inflate(inflater)
        return GoodsHolder(binding)
    }

    override fun onBindViewHolder(holder: GoodsHolder, position: Int) {
        holder.bind(goods[position])
    }

    inner class GoodsHolder(private val binding: CartCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Goods){
            binding.goods = item
            binding.model = GoodsModel(item)
        }
    }
}