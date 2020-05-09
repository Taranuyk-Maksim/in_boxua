package com.example.in_boxua.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.in_boxua.AddsToFavorites
import com.example.in_boxua.DataSingleton
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
            val isFavorites = Handler2(item)
            binding.goods = item
            binding.model = GoodsModel(item,isFavorites)
        }
    }
}

class Handler2(val goods: Goods) : AddsToFavorites {
    override fun toFavorite(isFavorites: Boolean) {
        if(isFavorites){
            DataSingleton.inFavorites.add(goods)
        }else{
            DataSingleton.inFavorites.remove(goods)
        }
    }
}