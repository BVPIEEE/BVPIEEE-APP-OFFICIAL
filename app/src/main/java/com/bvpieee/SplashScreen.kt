package com.bvpieee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreen : AppCompatActivity() {

    private val TimeSplash:Long=2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

//        avi.show()
        val animation = findViewById<LottieAnimationView>(R.id.lottieSplash)
        animation.speed = 1.0F // How fast does the animation play
        animation.addAnimatorUpdateListener {
        }
        animation.repeatMode = LottieDrawable.RESTART // Restarts the animation (you can choose to reverse it as well)
        animation.cancelAnimation()
        Handler().postDelayed(
            {
               val intent=Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }, TimeSplash
        )

    }
}