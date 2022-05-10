package com.example.startupappgro.animal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.startupappgro.databinding.ActivityAlimentacionBinding
import com.google.android.material.snackbar.Snackbar

class AlimentacionActivity : AppCompatActivity() {
    lateinit var binding: ActivityAlimentacionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlimentacionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.arrowBackspace.setOnClickListener {
            onBackPressed()
        }
        binding.linearLayoutFilter.setOnClickListener {
            Snackbar.make(binding.linearLayoutFilter, "Esta opción aún no está disponible", Toast.LENGTH_SHORT).show()
        }
        binding.tvVerMas.setOnClickListener {
            Snackbar.make(binding.tvVerMas, "Esta opción aún no está disponible", Toast.LENGTH_SHORT).show()
        }
    }
}