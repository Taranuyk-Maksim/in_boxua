package com.example.in_boxua.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.in_boxua.*
import com.example.in_boxua.databinding.CardForCartBinding

class GoodsFoCartAdapter(private val goods : List<Goods>
    ) : RecyclerView.Adapter<GoodsFoCartAdapter.GoodsHolder>() {

    override fun getItemCount() : Int = goods.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoodsHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding =  CardForCartBinding.inflate(inflater)
        return GoodsHolder(binding)
    }

    override fun onBindViewHolder(holder: GoodsHolder, position: Int) {
        holder.bind(goods[position])
    }

    inner class GoodsHolder(private val binding: CardForCartBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Goods){
            binding.goods = item
            binding.handler = ActionHandler(item)
        }
    }
}