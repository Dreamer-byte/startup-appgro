package com.example.startupappgro.provider

import android.app.Application
import android.content.Context
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import com.example.startupappgro.R
import com.example.startupappgro.model.ModelPreviewDiagnostic

class ProviderPreviewDiagnostic {
    companion object {
        var previewDiagnosticList = mutableListOf<ModelPreviewDiagnostic>(
            ModelPreviewDiagnostic(
                R.drawable.jardin1,
                "Hormonic",
                "Se ha detectado una serie de imperfeciones",
                "Estable",
                "Aplica estos químicos",
                R.drawable.shape_leaves
            )
        )
    }
}