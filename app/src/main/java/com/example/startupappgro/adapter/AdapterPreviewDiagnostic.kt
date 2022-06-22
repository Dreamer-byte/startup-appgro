package com.example.startupappgro.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.startupappgro.R
import com.example.startupappgro.model.ModelPreviewDiagnostic
import com.example.startupappgro.viewholder.ViewHolderPostCommunity
import com.example.startupappgro.viewholder.ViewHolderPreviewDiagnostic

class AdapterPreviewDiagnostic(
    private val diagnostic: MutableList<ModelPreviewDiagnostic>,
    private val onClickListener: (ModelPreviewDiagnostic) -> Unit
): RecyclerView.Adapter<ViewHolderPreviewDiagnostic>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPreviewDiagnostic {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolderPreviewDiagnostic(layoutInflater.inflate(R.layout.item_partial_diagnostic, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolderPreviewDiagnostic, position: Int) {
        val item = diagnostic[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount() = diagnostic.size
}