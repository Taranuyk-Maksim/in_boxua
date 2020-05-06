package com.example.in_boxua

import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.in_boxua.fragments.GoodsFragment


class GoodsModel (val goods: Goods)  {

    fun addToFavorite(){
        if(goods.isFavorites.get()){
            goods.isFavorites.set(false)
        }else{
            goods.isFavorites.set(true)
        }
    }
    //Button plas/minus quantity goods from cart
    fun goodsPlas() {
        goods.quantity.set(goods.quantity.get() + 1)
        goods.obsPrice.set(goods.obsPrice.get() + goods.price)
    }

    fun goodsMinus() {
        if(goods.quantity.get()>1) {
            goods.quantity.set(goods.quantity.get() - 1)
            goods.obsPrice.set(goods.obsPrice.get() - goods.price)
        }
    }

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
        Goods("Кросовочки ніке",800,disct,sizes,listPho)
    )


    fun open(view: View) {
        val manager = (view.context as AppCompatActivity).supportFragmentManager
        manager
            .beginTransaction()
            .replace(R.id.fl_fragment_container, GoodsFragment(goods,listGoo))
            .commit()
    }
}