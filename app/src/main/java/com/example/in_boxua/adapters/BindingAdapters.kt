package com.example.in_boxua.adapters

import android.graphics.drawable.Drawable
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableDouble
import com.example.in_boxua.R
import com.squareup.picasso.Picasso

@BindingAdapter("app:srcCompat")
fun bindSrcCompat(imageButton: ImageButton?, drawable: Drawable) {
    imageButton?.setImageDrawable(drawable)
}

@BindingAdapter("app:srcCompat")
fun bindSrcCompat(button: Button ?, drawable: Drawable) {
    button?.background = drawable
}

@BindingAdapter("app:btnText")
fun setText(button: Button ?, string: String) {
    button?.text = string
}

@BindingAdapter("app:text")
fun concat(textView: TextView?,price : ObservableDouble?) {
    val s : String = "${price?.get()} грн"
    textView?.text = s
}
@BindingAdapter("app:text")
fun concat(textView: TextView?,price : Double?) {
    val s : String = "$price грн"
    textView?.text = s
}
@BindingAdapter("app:url")
fun loadImage(view: ImageView?, url: String?) {
    Picasso.get()
        .load(url)
        .fit()
        .placeholder(R.drawable.placeholder)
        .error(R.drawable.image_eror)
        .into(view)
}