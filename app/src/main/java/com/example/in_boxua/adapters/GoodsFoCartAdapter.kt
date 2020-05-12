package com.example.in_boxua.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.in_boxua.*
import com.example.in_boxua.data.Goods
import com.example.in_boxua.models.GoodsInCartModel
import com.example.in_boxua.databinding.CardForCartBinding

class GoodsFoCartAdapter(private val listGoods : List<Goods>
    ) : RecyclerView.Adapter<GoodsFoCartAdapter.GoodsHolder>() {

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

    inner class GoodsHolder(private val binding: CardForCartBinding) : RecyclerView.ViewHolder(binding.root),
        AdapterUpdates,
        SumCalc{
        fun bind(item: Goods){
            binding.goods = item
            binding.model = GoodsInCartModel(item, this, this)
        }

        override fun removeItem() {
            notifyItemRemoved(itemPosition)
        }

        override fun calcSum() {
            var sum : Double = 0.0
            for (g in listGoods) {
                sum += g.obsPrice.get()
            }
            DataSingleton.sumAllGoodsInCart.set(sum)
        }
    }

}