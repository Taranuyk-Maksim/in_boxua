package com.example.in_boxua

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.in_boxua.fragments.GoodsFragment


class GoodsModel ()  {

    lateinit var presser : Presser

    lateinit var goods : Goods

    constructor(goods : Goods) : this(){
        this.goods = goods
    }
    constructor(goods : Goods, presser: Presser) : this(){
        this.goods = goods
        this.presser = presser
    }

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
        goods.obsPrice.set(goods.obsPrice.get() + goods.price!!)
        presser.onPress()
    }

    fun goodsMinus() {
        if(goods.quantity.get()>1) {
            goods.quantity.set(goods.quantity.get() - 1)
            goods.obsPrice.set(goods.obsPrice.get() - goods.price!!)
            presser.onPress()
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
        "https://images.ua.prom.st/1226436357_w640_h640_1226436357.jpg",
        "https://images.ua.prom.st/1854410440_w640_h640_krossovki-xiaomi-mijia.jpg",
        "https://krosogolik.com/image/cache/catalog/men-nike/7/281-1000x1340.jpg",
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
        Goods("Кросовочки ніке",800.0,disct,sizes,listPho),
        Goods("Кросовочки ніке",800.0,disct,sizes,listPho),
        Goods("Кросовочки ніке",800.0,disct,sizes,listPho),
        Goods("Кросовочки ніке",800.0,disct,sizes,listPho),
        Goods("Кросовочки ніке",800.0,disct,sizes,listPho),
        Goods("Кросовочки ніке",800.0,disct,sizes,listPho),
        Goods("Кросовочки ніке",800.0,disct,sizes,listPho),
        Goods("Кросовочки ніке",800.0,disct,sizes,listPho),
        Goods("Кросовочки ніке",800.0,disct,sizes,listPho),
        Goods("Кросовочки ніке",800.0,disct,sizes,listPho),
        Goods("Кросовочки ніке",800.0,disct,sizes,listPho),
        Goods("Кросовочки ніке",800.0,disct,sizes,listPho),
        Goods("Кросовочки ніке",800.0,disct,sizes,listPho),
        Goods("Кросовочки ніке",800.0,disct,sizes,listPho),
        Goods("Кросовочки ніке",800.0,disct,sizes,listPho),
        Goods("Кросовочки ніке",800.0,disct,sizes,listPho)

    )


    fun open(view: View) {
        val manager = (view.context as AppCompatActivity).supportFragmentManager
        manager
            .beginTransaction()
            .replace(R.id.fl_fragment_container, GoodsFragment(goods,listGoo))
            .commit()
    }
}

