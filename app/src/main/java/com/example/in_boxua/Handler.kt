package com.example.in_boxua

class Handler() : Presser{
    override fun onPress() {
        var sum : Double = 0.0
        for (g in DataSingleton.inCart) {
            sum += g.obsPrice.get()
        }
        DataSingleton.sumAllGoodsInCart.set(sum)
    }

}

