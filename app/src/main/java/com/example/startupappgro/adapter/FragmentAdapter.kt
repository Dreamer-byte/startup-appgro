package com.example.startupappgro.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.startupappgro.plant.fragment.AllPlantFragment
import com.example.startupappgro.plant.fragment.ExteriorsFragment
import com.example.startupappgro.plant.fragment.GardenFragment
import com.example.startupappgro.plant.fragment.InteriorsFragment

class FragmentAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> {
                AllPlantFragment()
            }
            1 -> {
                GardenFragment()
            }
            2 -> {
                InteriorsFragment()
            }
            3 -> {
                ExteriorsFragment()
            }
            else -> {
                Fragment()
            }
        }
    }

}