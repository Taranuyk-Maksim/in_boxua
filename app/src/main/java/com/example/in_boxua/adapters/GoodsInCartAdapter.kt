package com.example.in_boxua.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.in_boxua.R
import com.example.in_boxua.data.Goods
import com.example.in_boxua.ui.cart.GoodsInCartModel
import com.example.in_boxua.databinding.CardForCartBinding
import com.example.in_boxua.ui.cart.CartModel
import com.example.in_boxua.ui.cart.CartViewModel
import com.example.in_boxua.ui.goods.GoodsFragment
import com.example.in_boxua.utils.RecyclerViewUpdater
import com.example.in_boxua.utils.DataSingleton
import com.example.in_boxua.utils.SumCalc

class GoodsInCartAdapter (private val view : View, private val viewModel: CartViewModel): RecyclerView.Adapter<GoodsInCartAdapter.GoodsHolder>() {
    private lateinit var listGoods: List<Goods>

    fun setGoodsList(listGoods: List<Goods>) {
        this.listGoods = listGoods
    }

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

    fun calcSum() : Double {
        var sum : Double = 0.0
        for (g in listGoods) {
            sum += g.obsPrice.get()
        }
        return sum
    }

    inner class GoodsHolder(private val binding: CardForCartBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: Goods){
            binding.goods = item

            binding.cvCardInCart.setOnClickListener{
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

            binding.ibMinus.setOnClickListener {
                if(item.quantity.get() > 1){
                    item.obsPrice.set(item.obsPrice.get() - item.price)
                    item.quantity.set(item.quantity.get() - 1)
                }
            }

            binding.ibPlus.setOnClickListener {
                item.obsPrice.set(item.obsPrice.get() + item.price)
                item.quantity.set(item.quantity.get() + 1)
            }

            binding.ibRemove.setOnClickListener {
                CartModel(viewModel).remove(item)
            }
        }
    }
}