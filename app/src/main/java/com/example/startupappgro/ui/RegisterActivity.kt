package com.example.startupappgro.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doOnTextChanged
import com.example.startupappgro.R
import com.example.startupappgro.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    private var pass = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            this.finish()
        }
        binding.btnRegister.setOnClickListener {
            if (pass){
                startActivity(Intent(this, PresentationActivity::class.java))
            }else{
                binding.tilEmailRegister.error = "Ingrese un correo válido"
            }
            //this.finish()
        }
        binding.etEmailRegister.doOnTextChanged { text, _, _, _ ->
            if(text.toString().contains("@") && text.toString().endsWith(".com")){
                binding.tilEmailRegister.error = ""
                binding.tilEmailRegister.setEndIconDrawable(R.drawable.ic_baseline_check_circle_24)
                pass = true
            }else{
                binding.tilEmailRegister.setEndIconDrawable(R.drawable.ic_outline_check_circle_24)
                pass = false
            }
        }
    }
}