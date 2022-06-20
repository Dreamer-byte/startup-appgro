package com.example.startupappgro.adapter

import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.startupappgro.R
import com.example.startupappgro.model.ModelPostCommunity
import com.example.startupappgro.viewholder.ViewHolderPostCommunity

class AdapterPostCommunity(
    private val postCommunityList: MutableList<ModelPostCommunity>,
    private val onClickListener: (ModelPostCommunity) -> Unit
) : RecyclerView.Adapter<ViewHolderPostCommunity>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPostCommunity {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolderPostCommunity(layoutInflater.inflate(R.layout.item_post_community, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolderPostCommunity, position: Int) {
        val item = postCommunityList[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount() =  postCommunityList.size
}