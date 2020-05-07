package com.example.in_boxua.adapters

import android.widget.ImageButton
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso


@BindingAdapter("app:srcCompat")
fun bindSrcCompat(imageButton: ImageButton?, int: Int) {
    imageButton?.setImageResource(int)
}

@BindingAdapter("app:url")
fun loadImage(view: ImageView?, url: String?) {
    Picasso.get().load(url).into(view)
}