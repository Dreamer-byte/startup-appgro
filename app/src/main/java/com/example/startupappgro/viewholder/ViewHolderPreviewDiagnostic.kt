package com.example.startupappgro.viewholder

import android.graphics.Color
import android.view.View
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.recyclerview.widget.RecyclerView
import com.example.startupappgro.databinding.ItemPartialDiagnosticBinding
import com.example.startupappgro.databinding.ItemPostCommunityBinding
import com.example.startupappgro.model.ModelPreviewDiagnostic
import com.google.android.material.textview.MaterialTextView

class ViewHolderPreviewDiagnostic(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemPartialDiagnosticBinding.bind(view)
    fun render(item: ModelPreviewDiagnostic, onClickListener: (ModelPreviewDiagnostic) -> Unit) {
        binding.ivCapture.setImageResource(item.photo)
        binding.tvName.text = item.name
        binding.tvDescription.text = item.description
        binding.tvAlert.text = item.state
        binding.tvMessage.text = item.message
        binding.tvAlert.setBackgroundDrawable(getDrawable(binding.tvAlert.context, item.colorState))
        itemView.setOnClickListener {
            onClickListener(item)
        }
    }
}
