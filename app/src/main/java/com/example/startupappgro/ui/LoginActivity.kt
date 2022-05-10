package com.example.startupappgro.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.example.startupappgro.R
import com.example.startupappgro.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    private var pass = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
            this.finish()
        }
        binding.btnLogin.setOnClickListener {
            if (pass){
                startActivity(Intent(this, PresentationActivity::class.java))
            }else{
                binding.tilEmailLogin.error = "Ingrese un correo válido"
            }
            //this.finish()
        }
        binding.etEmailLogin.doOnTextChanged { text, _, _, _ ->
            if(text.toString().contains("@") && text.toString().endsWith(".com")){
                binding.tilEmailLogin.error = ""
                binding.tilEmailLogin.setEndIconDrawable(R.drawable.ic_baseline_check_circle_24)
                pass = true
            }else{
                binding.tilEmailLogin.setEndIconDrawable(R.drawable.ic_outline_check_circle_24)
                pass = false
            }
        }
    }
}