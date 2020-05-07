package com.example.in_boxua

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.in_boxua.fragments.CartFragment
import com.example.in_boxua.fragments.CatalogFragment
import com.example.in_boxua.fragments.FavoritesFragment
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
        "https://golos.ua/images/items/2019-03/14/e5VPi4QzRDkESm9G/image/1.png",
        "https://golos.ua/images/items/2019-03/14/e5VPi4QzRDkESm9G/image/1.png",
        "https://golos.ua/images/items/2019-03/14/e5VPi4QzRDkESm9G/image/1.png",
        "https://golos.ua/images/items/2019-03/14/e5VPi4QzRDkESm9G/image/1.png",
        "https://golos.ua/images/items/2019-03/14/e5VPi4QzRDkESm9G/image/1.png",
        "https://golos.ua/images/items/2019-03/14/e5VPi4QzRDkESm9G/image/1.png",
        "https://golos.ua/images/items/2019-03/14/e5VPi4QzRDkESm9G/image/1.png",
        "https://golos.ua/images/items/2019-03/14/e5VPi4QzRDkESm9G/image/1.png"
    )
    val disct : String  = "Практичная, лёгкая панама от Staff для туризма и повседневной жизни, которая защитит от солнца и влаги, а эксклюзивный принт поможет дополнить твой образ.\n" +
            "\n" +
            "Материал:\n" +
            "- прочный, дышащий полиэстер;\n" +
            "- 70% полиэстер, 30% коттон.\n" +
            "\n" +
            "Детали и крой:\n" +
            "- размер: высота (до козырька) 8 см, длина козырька 6 см, окружность 60 см;\n" +
            "- классический крой;\n" +
            "- лента-подкладка на внутренней стороне;\n" +
            "- четыре вентиляционных отверстия;\n" +
            "- бирка с фирменным логотипом Staff вшита в шов."
    val listGoo = arrayListOf<Goods>(
        Goods("Кросовочки ніке",800,disct,sizes,listPho),
        Goods("Кросовочки ніке",800,disct,sizes,listPho),
        Goods("Кросовочки ніке",800,disct,sizes,listPho),
        Goods("Кросовочки ніке",800,disct,sizes,listPho),
        Goods("Кросовочки ніке",800,disct,sizes,listPho),
        Goods("Кросовочки ніке",800,disct,sizes,listPho),
        Goods("Кросовочки ніке",800,disct,sizes,listPho),
        Goods("Кросовочки ніке",800,disct,sizes,listPho),
        Goods("Кросовочки ніке",800,disct,sizes,listPho)
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
                R.id.menu_catalog ->{
                    fragment = CatalogFragment(listPho,listGoo)
                }
                R.id.menu_favorites ->{
                    fragment = FavoritesFragment(listGoo)
                }
                R.id.menu_trash ->{
                    fragment = CartFragment(listGoo)
                }
            }

        return loadFragment(fragment);
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fl_fragment_container, fragment)
        transaction.commit()
    }
}
