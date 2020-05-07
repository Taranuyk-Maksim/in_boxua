package com.example.in_boxua.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.in_boxua.R
import com.squareup.picasso.Picasso

class PhotoAdapter (private val list: List<String>) : RecyclerView.Adapter<PhotoAdapter.PhotoHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.photo_card,parent,false)
        return PhotoHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }
    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {

        Picasso.get()
            .load(list[position])
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.image_eror)
            .fit()
            .into(holder.photo)
    }

     class PhotoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var photo : ImageView? = null
        init{
            photo = itemView.findViewById(R.id.iv_photo)
        }
    }
}