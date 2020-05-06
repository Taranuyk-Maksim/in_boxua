package com.example.in_boxua.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.in_boxua.Goods
import com.example.in_boxua.GoodsModel
import com.example.in_boxua.databinding.GoodsCardBinding

class GoodsAdapter(private val goods : List<Goods>) : RecyclerView.Adapter<GoodsAdapter.GoodsHolder>() {

    override fun getItemCount() : Int = goods.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoodsHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding =  GoodsCardBinding.inflate(inflater)
        return GoodsHolder(binding)
    }

    override fun onBindViewHolder(holder: GoodsHolder, position: Int) {
        holder.bind(goods[position])
    }

   inner class GoodsHolder(private val binding: GoodsCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Goods){
            binding.goods = item
            binding.model = GoodsModel(item)
        }
    }
}