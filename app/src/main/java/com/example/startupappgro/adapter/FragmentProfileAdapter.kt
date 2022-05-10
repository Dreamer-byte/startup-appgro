package com.example.startupappgro.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.startupappgro.plant.fragment.*

class FragmentProfileAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> {
                PublicationsFragment()
            }
            1 -> {
                EditProfileFragment()
            }
            else -> {
                Fragment()
            }
        }
    }
}