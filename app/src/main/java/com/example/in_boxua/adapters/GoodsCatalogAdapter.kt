package com.example.in_boxua.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.in_boxua.ui.goods.GoodsCardModel
import com.example.in_boxua.utils.RecyclerViewUpdater
import com.example.in_boxua.data.Goods
import com.example.in_boxua.databinding.GoodsCardBinding
import com.example.in_boxua.ui.favorites.FavoritesViewModel
import com.example.in_boxua.utils.FavoritesCallback

class GoodsCatalogAdapter : RecyclerView.Adapter<GoodsCatalogAdapter.GoodsHolder>() {

    private lateinit var goodsList : List<Goods>
    private var itemPosition : Int = 0
    private lateinit var viewModel : FavoritesViewModel

    fun setViewModel (viewModel: FavoritesViewModel) {
        this.viewModel = viewModel
    }
    override fun getItemCount() : Int = goodsList.size

    fun setGoodsList(goodsList: List<Goods>) {
        this.goodsList = goodsList
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

   inner class GoodsHolder(private val binding: GoodsCardBinding)
       : RecyclerView.ViewHolder(binding.root),
       RecyclerViewUpdater,
           FavoritesCallback

   {
        fun bind(item: Goods){
            val ah = GoodsCardModel(item)
            ah.setUpdater(this)
            ah.setAddsToFavorite(this)
            binding.goods = item
            binding.model = ah
        }
       override fun removeItem() {
           notifyItemRemoved(itemPosition)
       }

       override fun addFavorite(goods: Goods) {
          viewModel.addToFavorites(goods)
       }

       override fun removeFavorite(goods: Goods) {
           viewModel.removeFavorite(goods)
       }
   }
}

