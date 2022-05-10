package com.example.startupappgro.ui

import android.annotation.SuppressLint
import android.content.res.TypedArray
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.os.Bundle
import android.util.AttributeSet
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.startupappgro.R
import com.example.startupappgro.adapter.ViewPaperAdapter
import com.example.startupappgro.databinding.ActivityPresentationBinding
import com.example.startupappgro.transformer.DepthPageTransformer
import org.w3c.dom.Attr
import java.util.jar.Attributes

class PresentationActivity : AppCompatActivity() {
    private var imageList = mutableListOf<Int>()
    private var titleList = mutableListOf<String>()
    private var detailsList = mutableListOf<String>()
    private var mShadowPaint: Paint? = null
    private val deltaLength = 0f
    private var drawShadow = false
    private var cornerRadius = 0f
    private lateinit var binding: ActivityPresentationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPresentationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        postToList()
        binding.viewPaper2.adapter =
            ViewPaperAdapter(image = imageList, title = titleList, details = detailsList)
        binding.viewPaper2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.viewPaper2.setPageTransformer(DepthPageTransformer())
        val indicator = binding.indicator
        binding.viewPaper2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            @RequiresApi(Build.VERSION_CODES.Q)
            @SuppressLint("ResourceAsColor", "ResourceType")
            override fun onPageSelected(position: Int) {
                if (position == 0) {
                    //binding.shadow.setBackgroundColor(Color.BLUE)
                } else if (position == 1) {
                    //binding.shadow.setBackgroundColor(Color.GREEN)
                    //Toast.makeText(binding.card.context, binding.shadow.getAttributeResolutionStack(R.attr.containerShadowColor).toString(), Toast.LENGTH_SHORT).show()
                    val a: TypedArray =
                        this@PresentationActivity.obtainStyledAttributes(R.attr.containerShadowColor, R.styleable.ShadowContainer)
                    val shadowColor =
                        a.getColor(R.styleable.ShadowContainer_containerShadowColor, Color.GREEN)
                    cornerRadius =
                        a.getDimension(R.styleable.ShadowContainer_containerCornerRadius, 0f)
                    val dx = a.getDimension(R.styleable.ShadowContainer_deltaX, 0f)
                    val dy = a.getDimension(R.styleable.ShadowContainer_deltaY, 0f)
                    drawShadow = a.getBoolean(R.styleable.ShadowContainer_enable, true)
                    //      int shadowColor = Color.RED;
                    val shadowRadius =
                        a.getDimension(R.styleable.ShadowContainer_containerShadowRadius, 0f)
                    a.recycle()
                    mShadowPaint = Paint()
                    mShadowPaint!!.style = Paint.Style.FILL
                    mShadowPaint!!.isAntiAlias = true
                    mShadowPaint!!.color = shadowColor
                    mShadowPaint!!.setShadowLayer(shadowRadius, dx, dy, shadowColor)
                }
            }
        })
        indicator.setViewPager(binding.viewPaper2)
    }


    private fun addToList(image: Int, title: String, details: String) {
        titleList.add(title)
        detailsList.add(details)
        imageList.add(image)
    }

    private fun postToList() {
        addToList(
            R.drawable.animal_icon,
            "Animales",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
        )
        addToList(
            R.drawable.plant_icon,
            "Plantas",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
        )
    }

}