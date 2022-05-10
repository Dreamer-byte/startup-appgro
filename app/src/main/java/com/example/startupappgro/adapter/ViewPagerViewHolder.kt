package com.example.startupappgro.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat.getDrawable
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.startupappgro.R
import com.example.startupappgro.animal.HomeAnimalActivity
import com.example.startupappgro.databinding.ItemPresentationBinding
import com.example.startupappgro.plant.HomePlantActivity

class ViewPagerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemPresentationBinding.bind(view)
    @SuppressLint("SetTextI18n")
    fun render(itemImage: Int, itemTitle: String, itemDetails: String, position: Int){
        binding.imAnimal.setImageResource(itemImage)
        binding.tvDetail.text = itemDetails
        binding.tvTitle.text = itemTitle
        if (position == 0){
            binding.tvTitle.setTextColor(Color.parseColor("#6C63FF"))
            binding.btnStarting.visibility = AppCompatButton.VISIBLE
            binding.btnStarting.text = "¡VAMOS!"
            binding.btnStarting.setBackgroundColor(Color.parseColor("#6C63FF"))
            binding.btnStarting.setOnClickListener {
                val intent = Intent(binding.imAnimal.context, HomeAnimalActivity::class.java)
                startActivity(binding.imAnimal.context, intent, null)
            }
        }else{
            binding.tvTitle.setTextColor(Color.parseColor("#3F6953"))
            binding.btnStarting.visibility = AppCompatButton.VISIBLE
            binding.btnStarting.text = "¡VAMOS!"
            binding.btnStarting.setBackgroundColor(Color.parseColor("#3F6953"))
            binding.btnStarting.setOnClickListener {
                val intent = Intent(binding.imAnimal.context, HomePlantActivity::class.java)
                startActivity(binding.imAnimal.context, intent, null)
            }
        }
    }
}