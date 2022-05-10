package com.example.startupappgro.plant

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.startupappgro.*
import com.example.startupappgro.animal.HomeAnimalActivity
import com.example.startupappgro.animal.fragment.StartAnimalFragment
import com.example.startupappgro.databinding.ActivityHomeBinding

class HomePlantActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    private var showDrawer = false
    private lateinit var navController: NavController
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initDrawerLayout()
        binding.openDrawer.bringToFront()
        openDrawer()
        itemSelected()
    }

    private fun initDrawerLayout() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container_plant) as NavHostFragment
        navController = navHostFragment.navController
        NavigationUI.setupWithNavController(binding.btmNavigationPlant, navController)
        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.close, R.string.open)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun itemSelected() {
        binding.nvDrawerAnimal.setNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.itemAnimal -> {
                    startActivity(Intent(this, HomeAnimalActivity::class.java))
                    this.finish()
                }
                R.id.itemPlant -> binding.drawerLayout.closeDrawer(binding.nvDrawerAnimal, true)
            }
            true
        }
    }

    private fun openDrawer() {
        binding.openDrawer.setOnClickListener {
            binding.drawerLayout.openDrawer(binding.nvDrawerAnimal, true)
        }
    }
}