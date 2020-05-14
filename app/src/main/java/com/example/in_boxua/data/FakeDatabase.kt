package com.example.in_boxua.data

class FakeDatabase private constructor(){

    var goodsDao = FakeGoodsDao()
        private set


    companion object {
        @Volatile private var instance: FakeDatabase? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: FakeDatabase().also { instance = it }
            }
    }
}