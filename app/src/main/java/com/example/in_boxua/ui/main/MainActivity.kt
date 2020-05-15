package com.example.in_boxua.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.in_boxua.R
import com.example.in_boxua.ui.cart.CartFragment
import com.example.in_boxua.ui.catalog.CatalogFragment
import com.example.in_boxua.ui.favorites.FavoritesFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

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
                R.id.menu_trash -> loadFragment(CartFragment())
            }
            true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_fragment_container, fragment)
            addToBackStack(fragment.tag)
            commit()
        }
    }
}
