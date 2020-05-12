package com.example.in_boxua.data

class GoodsRepository private constructor(private val goodsDao: FakeGoodsDao) {

    fun addGoods(goods: Goods) {
        goodsDao.addGoods(goods)
    }

    fun getGoods() = goodsDao.getGoodsListCatalog()

    companion object {

        @Volatile
        private var instance: GoodsRepository? = null

        fun getInstance(goodsDao: FakeGoodsDao) =
            instance ?: synchronized(this) {
                instance ?: GoodsRepository(goodsDao).also { instance = it }
            }
    }
}