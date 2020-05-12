package com.example.in_boxua

import com.example.in_boxua.data.Goods
import com.example.in_boxua.data.SizeElement

object TestData {

    fun getSizes() = listOf<SizeElement>(
        SizeElement("xs"),
        SizeElement("s"),
        SizeElement("m"),
        SizeElement("l"),
        SizeElement("xl")
    )
    fun getNews() = listOf(
        "https://images.ua.prom.st/1169373685_w640_h640_muzhskie-krossovki-off-white.jpg",
        "https://images.ua.prom.st/1055060649_w640_h640_muzhskie-krossovki-nike.jpg",
        "https://images.ua.prom.st/1764741994_w640_h640_belye-krossovki-zhenskie.jpg"
    )
    fun getPhotos() = listOf(
        "https://golos.ua/images/items/2019-03/14/e5VPi4QzRDkESm9G/image/1.png",
        "https://golos.ua/images/items/2019-03/14/e5VPi4QzRDkESm9G/image/1.png",
        "https://golos.ua/images/items/2019-03/14/e5VPi4QzRDkESm9G/image/1.png",
        "https://images.ua.prom.st/1055060649_w640_h640_muzhskie-krossovki-nike.jpg",
        "https://images.ua.prom.st/1764741994_w640_h640_belye-krossovki-zhenskie.jpg"
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

    fun getGoodsList() = listOf(
        Goods(
            1,
            "Кросовки Nike 2020",
            200.0,
            disct,
            getSizes(),
            getPhotos()
        ),
        Goods(
            2,
            "Кросовки Nike 2020",
            200.0,
            disct,
            getSizes(),
            getPhotos()
        ),
        Goods(
            2,
            "Кросовки Nike 2020",
            200.0,
            disct,
            getSizes(),
            getPhotos()
        ),
        Goods(
            2,
            "Кросовки Nike 2020",
            200.0,
            disct,
            getSizes(),
            getPhotos()
        ),
        Goods(
            2,
            "Кросовки Nike 2020",
            200.0,
            disct,
            getSizes(),
            getPhotos()
        ),
        Goods(
            2,
            "Кросовки Nike 2020",
            200.0,
            disct,
            getSizes(),
            getPhotos()
        ),
        Goods(
            2,
            "Кросовки Nike 2020",
            200.0,
            disct,
            getSizes(),
            getPhotos()
        ),
        Goods(
            2,
            "Кросовки Nike 2020",
            200.0,
            disct,
            getSizes(),
            getPhotos()
        ),
        Goods(
            2,
            "Кросовки Nike 2020",
            200.0,
            disct,
            getSizes(),
            getPhotos()
        ),
        Goods(
            2,
            "Кросовки Nike 2020",
            200.0,
            disct,
            getSizes(),
            getPhotos()
        ),
        Goods(
            2,
            "Кросовки Nike 2020",
            200.0,
            disct,
            getSizes(),
            getPhotos()
        ),
        Goods(
            2,
            "Кросовки Nike 2020",
            200.0,
            disct,
            getSizes(),
            getPhotos()
        ),
        Goods(
            2,
            "Кросовки Nike 2020",
            200.0,
            disct,
            getSizes(),
            getPhotos()
        ),
        Goods(
            2,
            "Кросовки Nike 2020",
            200.0,
            disct,
            getSizes(),
            getPhotos()
        )
    )
}