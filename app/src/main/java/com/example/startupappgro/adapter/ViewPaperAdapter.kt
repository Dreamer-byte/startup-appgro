package com.example.startupappgro.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.startupappgro.R

class ViewPaperAdapter(private var image: List<Int>, private var title: List<String>, private var details: List<String>) :
    RecyclerView.Adapter<ViewPagerViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewPagerViewHolder {
        return ViewPagerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_presentation, parent, false ))
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.render(itemImage = image[position], itemTitle = title[position], itemDetails = details[position], position = position)
    }

    override fun getItemCount(): Int {
        return title.size
    }

}