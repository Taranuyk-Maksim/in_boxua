package com.example.in_boxua

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.in_boxua.fragments.CartFragment
import com.example.in_boxua.fragments.CatalogFragment
import com.example.in_boxua.fragments.FavoritesFragment
import com.example.in_boxua.fragments.ResultFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    val sizes = listOf<String>(
        "s",
        "m",
        "l",
        "xl",
        "xxl"
    )
    val listPho = listOf(
        R.drawable.snekers_photo,
        R.drawable.snekers_photo,
        R.drawable.snekers_photo,
        R.drawable.snekers_photo
    )
    val listGoo = arrayListOf<Goods>(
        Goods("Кросовочки ніке",800,sizes,listPho),
        Goods("Кросовочки ніке",800,sizes,listPho),
        Goods("Кросовочки ніке",800,sizes,listPho),
        Goods("Кросовочки ніке",800,sizes,listPho),
        Goods("Кросовочки ніке",800,sizes,listPho),
        Goods("Кросовочки ніке",800,sizes,listPho),
        Goods("Кросовочки ніке",800,sizes,listPho),
        Goods("Кросовочки ніке",800,sizes,listPho),
        Goods("Кросовочки ніке",800,sizes,listPho),
        Goods("Кросовочки ніке",800,sizes,listPho),
        Goods("Кросовочки ніке",800,sizes,listPho)

    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(CatalogFragment(listPho,listGoo))

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

        when (item.itemId) {
            R.id.menu_catalog ->
                fragment = CatalogFragment(listPho,listGoo)
            R.id.menu_favorites ->
                fragment = FavoritesFragment(listGoo)
            R.id.menu_trash ->
                fragment = CartFragment(listGoo)
        }
        return loadFragment(fragment);
    }
}
