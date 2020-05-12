package com.example.in_boxua.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.in_boxua.R
import com.example.in_boxua.data.SizeElement

class SizeElementAdapter(private val sizeList: List<SizeElement>): RecyclerView.Adapter<SizeElementAdapter.SizeElementHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SizeElementHolder {
        val itemVIew = LayoutInflater.from(parent.context).inflate(R.layout.size_element,parent,false)
        return SizeElementHolder(itemVIew)
    }

    override fun getItemCount() = sizeList.size

    override fun onBindViewHolder(holder: SizeElementHolder, position: Int) {
        holder.element?.text = sizeList[position].sizeElement

        holder.element?.setOnClickListener {
            if (sizeList[position].isPress.get()){
                holder.element?.setBackgroundResource(R.drawable.background_fill_blue)
            }

        }
    }

    inner class SizeElementHolder(item : View) : RecyclerView.ViewHolder(item){
        var element : Button? = null

        init {
            element = item.findViewById(R.id.bt_setSize)
        }
    }
}