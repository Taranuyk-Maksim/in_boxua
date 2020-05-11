package com.example.in_boxua.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.in_boxua.ActionHandler
import com.example.in_boxua.AdapterUpdates
import com.example.in_boxua.Goods
import com.example.in_boxua.databinding.GoodsCardBinding
import com.example.in_boxua.viewModels.FavoritesViewModel

class GoodsAdapter(private var goodsList : List<Goods>) : RecyclerView.Adapter<GoodsAdapter.GoodsHolder>(),AdapterUpdates  {

    override fun getItemCount() : Int = goodsList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoodsHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding =  GoodsCardBinding.inflate(inflater)
        return GoodsHolder(binding,this)
    }

    override fun onBindViewHolder(holder: GoodsHolder, position: Int) {
        holder.bind(goodsList[position])
    }

   inner class GoodsHolder(private val binding: GoodsCardBinding,var updates: AdapterUpdates) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Goods){
            val ah = ActionHandler(item)
            ah.setUpdater(updates)
            binding.goods = item
            binding.handler = ah
        }
    }

    override fun toUpdate() {
        notifyDataSetChanged()
    }
}

