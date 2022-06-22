package com.example.startupappgro.model

import android.graphics.drawable.Drawable

data class ModelPreviewDiagnostic(
    val photo: Int,
    val name: String,
    val description: String,
    val state: String,
    val message: String,
    val colorState: Int
)
