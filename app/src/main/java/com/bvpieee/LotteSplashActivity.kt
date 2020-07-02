package com.bvpieee

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView

class LotteSplashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lotte_splash)

        val animation = findViewById<LottieAnimationView>(R.id.team)
        animation.speed = 2.0F
        animation.addAnimatorUpdateListener {}

//        val animation2=findViewById<LottieAnimationView>(R.id.animationView)
//        animation2.speed=2.0F
//        animation2.addAnimatorUpdateListener {  }

        val handler = Handler()
        val x = Runnable { finish() }
        handler.postDelayed(x, 2000)

    }
}