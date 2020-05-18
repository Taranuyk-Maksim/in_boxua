package com.example.in_boxua.ui.goods

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.in_boxua.*
import com.example.in_boxua.adapters.GoodsAdapter
import com.example.in_boxua.adapters.PhotoAdapter
import com.example.in_boxua.adapters.SizeElementAdapter
import com.example.in_boxua.data.Goods
import com.example.in_boxua.data.SizeElement
import com.example.in_boxua.databinding.FragmentGoodsBinding
import com.example.in_boxua.ui.cart.CartViewModel
import com.example.in_boxua.ui.catalog.CatalogFragment
import com.example.in_boxua.ui.favorites.FavoritesViewModel
import com.example.in_boxua.utils.InjectorUtils

class GoodsFragment(val goods: Goods) : Fragment() {
    private val favFactory = InjectorUtils.provideFavoritesGoodsViewModelFactory()
    private val  favViewModel by lazy { ViewModelProviders.of(this,favFactory).get(FavoritesViewModel::class.java)}

    private val cartFactory = InjectorUtils.provideCartViewModelFactory()
    private val  cartViewModel by lazy { ViewModelProviders.of(this,cartFactory).get(CartViewModel::class.java)}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_goods,null)

        initRecycler(view,goods.photos,goods.sizeLIst)

        val bind : FragmentGoodsBinding = FragmentGoodsBinding.bind(view)
        bind.goods = goods

        bind.ibBack.setOnClickListener {
            val manager = (view.context as AppCompatActivity).supportFragmentManager
            manager.popBackStack()
        }
        bind.ibFavorite.setOnClickListener {
            if (goods.isFavorites.get()) {
                goods.isFavorites.set(false)
                GoodsModel(favViewModel).removeFavorite(goods)
            } else {
                goods.isFavorites.set(true)
                GoodsModel(favViewModel).addFavorite(goods)
            }
        }

        bind.addToCart.setOnClickListener {
            if (goods.isInCart.get()) {
                goods.isInCart.set(false)
                cartViewModel.remove(goods)
                it.setBackgroundColor(Color.GRAY)
            } else {
                goods.isInCart.set(true)
                cartViewModel.addToCart(goods)
                it.setBackgroundColor(Color.GREEN)
            }

        }

        return view
    }

    private fun initRecycler(view: View, listPhotos: List<String>,
                             listSizes : List<SizeElement>){

        val sizes : RecyclerView = view.findViewById(R.id.rv_sizes)
        val photos : RecyclerView = view.findViewById(R.id.rv_photos)

        val recommend : RecyclerView = view.findViewById(R.id.rv_recomend)
        val recommendAdapter = GoodsAdapter(GoodsModel(favViewModel),view)
        recommendAdapter.setGoodsList(TestData.getGoodsList())

        recommend.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        recommend.adapter = recommendAdapter

        sizes.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        photos.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        recommend.adapter = recommendAdapter

        sizes.adapter = SizeElementAdapter(listSizes)
        photos.adapter = PhotoAdapter(listPhotos)
    }
}