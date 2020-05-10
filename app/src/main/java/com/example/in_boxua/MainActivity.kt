package com.example.in_boxua

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.in_boxua.fragments.CartFragment
import com.example.in_boxua.fragments.CatalogFragment
import com.example.in_boxua.fragments.FavoritesFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(CatalogFragment())

        val navigation: BottomNavigationView = findViewById(R.id.bottomNavigationView)

        if(DataSingleton.inFavorites.isNotEmpty()){
            navigation.getOrCreateBadge(R.id.menu_favorites).number = DataSingleton.inFavorites.size
        }

        navigation.setOnNavigationItemSelectedListener(this)
    }

    private fun loadFragment(fragment: Fragment?): Boolean {
        //switching fragment
        if (fragment != null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fl_fragment_container, fragment)
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
                    fragment = FavoritesFragment()
                }
                R.id.menu_trash ->{
                    fragment = CartFragment()
                }
            }

        return loadFragment(fragment);
    }
}
