package com.example.in_boxua.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.in_boxua.R
import com.example.in_boxua.ui.cart.CartFragment
import com.example.in_boxua.ui.cart.CartViewModel
import com.example.in_boxua.ui.catalog.CatalogFragment
import com.example.in_boxua.ui.favorites.FavoritesFragment
import com.example.in_boxua.ui.favorites.FavoritesViewModel
import com.example.in_boxua.utils.InjectorUtils
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var currentFragment = CatalogFragment().tag.toString()

    private val favFactory = InjectorUtils.provideFavoritesGoodsViewModelFactory()
    private val  favViewModel by lazy { ViewModelProviders.of(this,favFactory).get(FavoritesViewModel::class.java)}

    private val cartFactory = InjectorUtils.provideCartViewModelFactory()
    private val cartViewModel by lazy { ViewModelProviders.of(this,cartFactory).get(CartViewModel::class.java)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(CatalogFragment())
        menuInit()
    }

    private fun menuInit() {
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.menu_catalog -> loadFragment(CatalogFragment())
                R.id.menu_favorites -> loadFragment(FavoritesFragment())
                R.id.menu_cart -> loadFragment(CartFragment())
            }
            true
        }
        favViewModel.getFavoritesGoods().observe(this, Observer {
            it?.let {
                bottomNavigationView.getOrCreateBadge(R.id.menu_favorites).apply {
                    if(it.isNotEmpty()) {
                        isVisible = true
                        number = it.size
                    }else {
                        isVisible = false
                    }
                }
            }
        })
        cartViewModel.getCartList().observe(this, Observer {
            it?.let {
                bottomNavigationView.getOrCreateBadge(R.id.menu_cart).apply {
                    if (it.isNotEmpty()) {
                        isVisible = true
                        number = it.size
                    } else {
                        isVisible = false
                    }
                }
            }
        })
    }

    private fun loadFragment(fragment: Fragment) {
           supportFragmentManager.beginTransaction().apply {
               replace(R.id.fl_fragment_container, fragment)
               addToBackStack(fragment.tag)
               commit()
           }
           currentFragment = fragment.tag.toString()
    }
}
