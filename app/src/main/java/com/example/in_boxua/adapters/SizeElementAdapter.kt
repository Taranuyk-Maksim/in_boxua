package com.example.in_boxua.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.in_boxua.R

class SizeElementAdapter(private val sizeList: List<String>): RecyclerView.Adapter<SizeElementAdapter.SizeElementHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SizeElementHolder {
        val itemVIew = LayoutInflater.from(parent.context).inflate(R.layout.size_element,parent,false)
        return SizeElementHolder(itemVIew)
    }

    override fun getItemCount() = sizeList.size

    override fun onBindViewHolder(holder: SizeElementHolder, position: Int) {
        holder.text?.text = sizeList[position]
    }

    inner class SizeElementHolder(item : View) : RecyclerView.ViewHolder(item){
        var text : TextView? = null
        init {
            text =  item.findViewById(R.id.tv_size_element)
        }
    }
}