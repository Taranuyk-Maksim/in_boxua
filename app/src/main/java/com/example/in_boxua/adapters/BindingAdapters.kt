package com.example.in_boxua.adapters

import android.graphics.drawable.Drawable
import android.widget.ImageButton
import androidx.databinding.BindingAdapter


@BindingAdapter("app:srcCompat")
fun bindSrcCompat(imageButton: ImageButton?, int: Int) {
    imageButton?.setImageResource(int)
}