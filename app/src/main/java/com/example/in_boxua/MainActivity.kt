package com.example.in_boxua

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.in_boxua.ui.cart.CartFragment
import com.example.in_boxua.ui.catalog.CatalogFragment
import com.example.in_boxua.ui.favorites.FavoritesFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(CatalogFragment())

        val navigation: BottomNavigationView = findViewById(R.id.bottomNavigationView)

        if(DataSingleton.favoritesGoods.isNotEmpty()){
            navigation.getOrCreateBadge(R.id.menu_favorites).number = 5
        }
        navigation.getOrCreateBadge(R.id.menu_favorites).number = 6
        navigation.setOnNavigationItemSelectedListener(this)
    }

    private fun loadFragment(fragment: Fragment?): Boolean {
        //switching fragment
        if (fragment != null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fl_fragment_container, fragment)
                .addToBackStack(fragment.tag)
                .commit()
            return true
        }
        return false
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragment : Fragment? = null

        when (item.itemId) {
                R.id.menu_catalog ->{
                    fragment = CatalogFragment()
                }
                R.id.menu_favorites ->{
                    fragment =
                        FavoritesFragment()
                }
                R.id.menu_trash ->{
                    fragment = CartFragment()
                }
            }

        return loadFragment(fragment);
    }
}
