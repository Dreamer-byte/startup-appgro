package com.example.startupappgro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.startupappgro.databinding.ActivityWarningBinding
import com.example.startupappgro.ui.LoginActivity

class WarningActivity : AppCompatActivity() {
    lateinit var binding: ActivityWarningBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWarningBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lottieInfo.animate()
        binding.btnContinuar.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}