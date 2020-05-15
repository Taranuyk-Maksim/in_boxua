package com.example.in_boxua.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.in_boxua.ui.goods.GoodsCardModel
import com.example.in_boxua.utils.RecyclerViewUpdater
import com.example.in_boxua.data.Goods
import com.example.in_boxua.databinding.GoodsCardBinding
import com.example.in_boxua.utils.FavoritesCallback

class GoodsAdapter(var favoritesCallback: FavoritesCallback) : RecyclerView.Adapter<GoodsAdapter.GoodsHolder>() {

    private lateinit var goodsList : List<Goods>
    private var itemPosition : Int = 0

    override fun getItemCount() : Int = goodsList.size

    fun setGoodsList(goodsList: List<Goods>) {
        this.goodsList = goodsList
        notifyItemInserted(itemPosition)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoodsHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding =  GoodsCardBinding.inflate(inflater)
        return GoodsHolder(binding)
    }

    override fun onBindViewHolder(holder: GoodsHolder, position: Int) {
        holder.bind(goodsList[position])
        itemPosition = position
    }

   inner class GoodsHolder(private val binding: GoodsCardBinding) : RecyclerView.ViewHolder(binding.root),
       RecyclerViewUpdater{

        fun bind(item: Goods){
            val ah = GoodsCardModel(item)
            ah.setUpdater(this)
            ah.setAddsToFavorite(favoritesCallback)
            binding.goods = item
            binding.model = ah
        }
       override fun removeItem() {
           notifyItemRemoved(itemPosition)
       }
   }
}

