package com.example.in_boxua.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.in_boxua.R
import com.example.in_boxua.data.Goods
import com.example.in_boxua.databinding.GoodsCardBinding
import com.example.in_boxua.ui.goods.GoodsFragment
import com.example.in_boxua.utils.FavoritesCallback
import javax.inject.Inject

class GoodsAdapter(private var fav : FavoritesCallback,var view : View) : RecyclerView.Adapter<GoodsAdapter.GoodsHolder>() {

    private lateinit var goodsList : List<Goods>
    private var itemPosition : Int = 0

    override fun getItemCount() : Int = goodsList.size

    fun getPosition() : Int{
        return itemPosition
    }
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

    inner class GoodsHolder(private val binding: GoodsCardBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Goods){
            binding.goods = item

            binding.ibAddToFavorite.setOnClickListener {
                if (item.isFavorites.get()) {
                    item.isFavorites.set(false)
                    fav.removeFavorite(item)
                } else {
                    item.isFavorites.set(true)
                    fav.addFavorite(item)
                }
            }

            binding.cvGoods.setOnClickListener {
                val manager = (view.context as AppCompatActivity).supportFragmentManager
                manager
                    .beginTransaction()
                    .replace(
                        R.id.fl_fragment_container,
                        GoodsFragment(
                            item
                        )
                    )
                    .addToBackStack("itemId.toString()")
                    .commit()
            }
        }
    }
}

