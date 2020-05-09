package com.example.in_boxua

import androidx.databinding.ObservableDouble

object DataSingleton{

    val sumAllGoodsInCart = ObservableDouble()

    //Goods in cart
    var inCart : ArrayList<Goods> = ArrayList()

    //Favorites goods
    var inFavorites : ArrayList<Goods> = ArrayList()

    //Recommend list
    var recommendedGoods : ArrayList<Goods> = ArrayList()

//    val sizes = listOf<String>(
//        "s",
//        "m",
//        "l",
//        "xl",
//        "xxl"
//    )
//    val listPho = listOf(
//        "https://images.ua.prom.st/1226436357_w640_h640_1226436357.jpg",
//        "https://images.ua.prom.st/1854410440_w640_h640_krossovki-xiaomi-mijia.jpg",
//        "https://krosogolik.com/image/cache/catalog/men-nike/7/281-1000x1340.jpg",
//        "https://golos.ua/images/items/2019-03/14/e5VPi4QzRDkESm9G/image/1.png"
//    )
//    val disct : String  = "Практичная, лёгкая панама от Staff для туризма и повседневной жизни, которая защитит от солнца и влаги, а эксклюзивный принт поможет дополнить твой образ.\n" +
//            "\n" +
//            "Материал:\n" +
//            "- прочный, дышащий полиэстер;\n" +
//            "- 70% полиэстер, 30% коттон.\n" +
//            "\n" +
//            "Детали и крой:\n" +
//            "- размер: высота (до козырька) 8 см, длина козырька 6 см, окружность 60 см;\n" +
//            "- классический крой;\n" +
//            "- лента-подкладка на внутренней стороне;\n" +
//            "- четыре вентиляционных отверстия;\n" +
//            "- бирка с фирменным логотипом Staff вшита в шов."
//    fun init (){
//        recommendedGoods.add(Goods(1,"Кросовочки ніке",800.0,disct,sizes,listPho))
//        recommendedGoods.add(Goods(1,"Кросовочки ніке",800.0,disct,sizes,listPho))
//        recommendedGoods.add(Goods(1,"Кросовочки ніке",800.0,disct,sizes,listPho))
//        recommendedGoods.add(Goods(1,"Кросовочки ніке",800.0,disct,sizes,listPho))
//        recommendedGoods.add(Goods(1,"Кросовочки ніке",800.0,disct,sizes,listPho))
//        recommendedGoods.add(Goods(1,"Кросовочки ніке",800.0,disct,sizes,listPho))
//        recommendedGoods.add(Goods(1,"Кросовочки ніке",800.0,disct,sizes,listPho))
//        recommendedGoods.add(Goods(1,"Кросовочки ніке",800.0,disct,sizes,listPho))
//        recommendedGoods.add(Goods(1,"Кросовочки ніке",800.0,disct,sizes,listPho))
//        recommendedGoods.add(Goods(1,"Кросовочки ніке",800.0,disct,sizes,listPho))
//        recommendedGoods.add(Goods(1,"Кросовочки ніке",800.0,disct,sizes,listPho))
//        recommendedGoods.add(Goods(1,"Кросовочки ніке",800.0,disct,sizes,listPho))
//        recommendedGoods.add(Goods(1,"Кросовочки ніке",800.0,disct,sizes,listPho))
//    }

}