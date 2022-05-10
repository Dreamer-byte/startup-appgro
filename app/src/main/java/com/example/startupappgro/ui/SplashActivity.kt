package com.example.startupappgro.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.widget.AppCompatImageView
import com.example.startupappgro.R
import com.example.startupappgro.WarningActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    lateinit var ivImage: AppCompatImageView
    lateinit var ivName: AppCompatImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        val animationImageDrawable: Animation = AnimationUtils.loadAnimation(this, R.anim.scroll_up)
        val animationImageName: Animation = AnimationUtils.loadAnimation(this, R.anim.scroll_down)
        ivImage = findViewById(R.id.ivAppgro)
        ivName = findViewById(R.id.ivNameAppgro)
        ivName.animation = animationImageName
        ivImage.animation = animationImageDrawable
        Handler().postDelayed({
            startActivity(Intent(this, WarningActivity::class.java))
            this.finish()
        }, 4000)
    }
}