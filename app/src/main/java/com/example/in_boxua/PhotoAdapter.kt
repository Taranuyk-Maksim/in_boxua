package com.example.in_boxua

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView

class PhotoAdapter (private val list: List<Int>) : RecyclerView.Adapter<PhotoAdapter.PhotoHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.photo_card,parent,false)
        return PhotoHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }
    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
         holder.photo?.setImageResource(list[position])
    }
    class PhotoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var photo : ImageView? = null
        init{
            photo = itemView.findViewById(R.id.iv_photo)
        }
    }
}