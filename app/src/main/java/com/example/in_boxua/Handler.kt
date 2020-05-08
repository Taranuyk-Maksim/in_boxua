package com.example.in_boxua

import com.example.in_boxua.fragments.CategoryFragment
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class Handler{
    fun openCatalog(view: View) {
        val manager = (view.context as AppCompatActivity).supportFragmentManager
        manager
            .beginTransaction()
            .replace(R.id.fl_fragment_container, CategoryFragment())
            .commit()
    }
}