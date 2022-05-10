package com.example.startupappgro.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.startupappgro.animal.fragment.AlimentacionMascotaFragment
import com.example.startupappgro.animal.fragment.PerfilMascotaFragment
import com.example.startupappgro.plant.fragment.AllPlantFragment
import com.example.startupappgro.plant.fragment.ExteriorsFragment
import com.example.startupappgro.plant.fragment.GardenFragment
import com.example.startupappgro.plant.fragment.InteriorsFragment

class FragmentMascotaAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> {
                PerfilMascotaFragment()
            }
            1 -> {
                AlimentacionMascotaFragment()
            }
            else -> {
                Fragment()
            }
        }
    }

}