package com.example.in_boxua

class PressListener {
    interface myOnPressListener {
        fun onPress()
    }

    lateinit var onPressListener : myOnPressListener

    fun setListener(listener: myOnPressListener){
        this.onPressListener = listener
    }

}