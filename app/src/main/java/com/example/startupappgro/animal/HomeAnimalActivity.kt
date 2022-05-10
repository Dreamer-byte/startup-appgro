package com.example.startupappgro.animal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.startupappgro.R
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.startupappgro.databinding.ActivityHomeAnimalBinding

class HomeAnimalActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeAnimalBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeAnimalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager.findFragmentById(binding.fragmentContainerAnimal.id) as NavHostFragment
        navController = navHostFragment.navController
        setupWithNavController(binding.btnNavigationAnimal, navController)
    }
}