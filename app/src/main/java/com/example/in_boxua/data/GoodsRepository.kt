package com.example.in_boxua.data

class GoodsRepository private constructor(private val goodsDao: FakeGoodsDao) {

    fun addGoods(goods: Goods) {
        goodsDao.addGoods(goods)
    }
    fun getGoods() = goodsDao.getGoodsList()

    fun addToFavorites(goods: Goods) {
        goodsDao.addToFavorites(goods)
    }

    fun removeFavoritesGoods(goods: Goods) {
        goodsDao.removeFavoriteGods(goods)
    }

    fun getFavoritesList() = goodsDao.getFavoritesList()

    fun addToCart(goods: Goods) {
        goodsDao.addToCart(goods)
    }

    fun removeInCartGoods(goods: Goods) {
        goodsDao.removeInCartGods(goods)
    }

    fun getCartList() = goodsDao.getCartList()

    companion object {

        @Volatile
        private var instance: GoodsRepository? = null

        fun getInstance(goodsDao: FakeGoodsDao) =
            instance ?: synchronized(this) {
                instance ?: GoodsRepository(goodsDao).also { instance = it }
            }
    }
}