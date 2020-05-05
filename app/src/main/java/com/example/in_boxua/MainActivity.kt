package com.example.in_boxua

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //loading the default fragment

        //loading the default fragment
        loadFragment(CatalogFragment())

        //getting bottom navigation view and attaching the listener

        //getting bottom navigation view and attaching the listener
        val navigation: BottomNavigationView = findViewById(R.id.bottomNavigationView)
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

        var arra = arrayListOf<Goods>(
            Goods("230432",234),
            Goods("230432",234),
            Goods("230432",234),
            Goods("230432",234)
        )
        when (item.itemId) {
            R.id.menu_catalog ->
                fragment = CatalogFragment()
            R.id.menu_favorites ->
                fragment = FavoritesFragment()
            R.id.menu_trash ->
                fragment = CartFragment(arra)
        }
        return loadFragment(fragment);
    }
}
