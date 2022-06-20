package com.example.startupappgro.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.startupappgro.R
import com.example.startupappgro.databinding.ItemPostCommunityBinding
import com.example.startupappgro.model.ModelPostCommunity

class ViewHolderPostCommunity(view: View):RecyclerView.ViewHolder(view) {
    private val binding = ItemPostCommunityBinding.bind(view)
    fun render(item: ModelPostCommunity, onClickListener: (ModelPostCommunity) -> Unit){
        binding.ivAvatar.setImageResource(item.photo)
        binding.tvName.text = item.name
        binding.tvConnected.text = item.timePost
        binding.options.setImageResource(item.options)
        binding.tvDescription.text = item.description
        binding.ivPost.setImageResource(item.photoPost)
        binding.tvNumReaction.text = item.reactions
        binding.tvNumComment.text = item.comments
        itemView.setOnClickListener {
            onClickListener(item)
        }
    }
}