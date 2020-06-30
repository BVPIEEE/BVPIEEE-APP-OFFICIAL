package com.bvpieee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreen : AppCompatActivity() {

    private val TimeSplash:Long=5000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        avi.show()
        Handler().postDelayed(
            {
               val intent=Intent(this,HomeActivity::class.java)
                startActivity(intent)
                finish()
            }, TimeSplash
        )

    }
}