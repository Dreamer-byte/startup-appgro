package com.example.startupappgro.animal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.startupappgro.adapter.FragmentMascotaAdapter
import com.example.startupappgro.databinding.ActivityAddMascotaBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator

class AddMascotaActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddMascotaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddMascotaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.pagerPerfil.isSaveEnabled = false
        val adapter = FragmentMascotaAdapter(fragmentManager = supportFragmentManager, lifecycle = lifecycle)
        binding.pagerPerfil.adapter = adapter
        TabLayoutMediator(binding.tabLayoutPerfil, binding.pagerPerfil
        ) { tab, position ->
            when(position){
                0 -> {
                    tab.text = "Perfil"
                }
                1 -> {
                    tab.text = "Alimentación"
                }
            }
        }.attach()
        binding.ivBackAddMascota.setOnClickListener {
            onBackPressed()
        }
        binding.ivAdd.setOnClickListener {
            Snackbar.make(binding.ivAdd, "Esta opción aún no está disponible", Toast.LENGTH_SHORT).show()
        }
    }
}