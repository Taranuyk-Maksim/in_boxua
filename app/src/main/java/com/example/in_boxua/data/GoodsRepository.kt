package com.example.in_boxua.data

class QuoteRepository private constructor(private val goodsDao: FakeGoodsDao) {

    // Imagine a code which also updates and checks the backend.
    fun addQuote(goods: Goods) {
        goodsDao.addGoods(goods)
    }

    fun getQuotes() = goodsDao.getGoodses()

    companion object {
        // Singleton instantiation you already know and love
        @Volatile
        private var instance: QuoteRepository? = null

        fun getInstance(quoteDao: FakeGoodsDao) =
            instance ?: synchronized(this) {
                instance ?: QuoteRepository(quoteDao).also { instance = it }
            }
    }
}