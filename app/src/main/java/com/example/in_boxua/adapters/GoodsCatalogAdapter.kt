package com.example.in_boxua.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.in_boxua.models.GoodsCardModel
import com.example.in_boxua.AdapterUpdates
import com.example.in_boxua.data.Goods
import com.example.in_boxua.databinding.GoodsCardBinding

class GoodsCatalogAdapter(private var goodsList : List<Goods>) : RecyclerView.Adapter<GoodsCatalogAdapter.GoodsHolder>() {

    override fun getItemCount() : Int = goodsList.size
    private var itemPosition : Int = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoodsHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding =  GoodsCardBinding.inflate(inflater)
        return GoodsHolder(binding)
    }

    override fun onBindViewHolder(holder: GoodsHolder, position: Int) {
        holder.bind(goodsList[position])
        itemPosition = position
    }

   inner class GoodsHolder(private val binding: GoodsCardBinding)
       : RecyclerView.ViewHolder(binding.root), AdapterUpdates {

        fun bind(item: Goods){
            val ah = GoodsCardModel(item)
            ah.setUpdater(this)
            binding.goods = item
            binding.model = ah
        }
       override fun removeItem() {
           notifyItemRemoved(itemPosition)
       }
   }
}

