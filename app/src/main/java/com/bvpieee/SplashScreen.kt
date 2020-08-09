package com.bvpieee

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {

    private val TimeSplash:Long=2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        avi.show()
//        val animation = findViewById<LottieAnimationView>(R.id.lottieSplash)
//        animation.speed = 1.0F // How fast does the animation play
//        animation.addAnimatorUpdateListener {
//        }
//        animation.repeatMode = LottieDrawable.RESTART // Restarts the animation (you can choose to reverse it as well)
//        animation.cancelAnimation()
//        Handler().postDelayed(
//            {
//               val intent=Intent(this, LoginActivity::class.java)
//                startActivity(intent)
//                finish()
//            }, TimeSplash
//        )
        val intent= Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()

    }
}