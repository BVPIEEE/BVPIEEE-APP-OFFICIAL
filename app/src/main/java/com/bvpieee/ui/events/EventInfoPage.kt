package com.bvpieee.ui.events

import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsIntent
import com.bvpieee.R
import com.bvpieee.utils.ImageHandler
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_event_info.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

//const val YOUTUBE_VIDEO_ID = "oGG0tU_XGnc"
var YOUTUBE_VIDEO_LINK: String? = ""
val TAG = "EventInfoPage"

class EventInfoPage : YouTubeBaseActivity(), YouTubePlayer.OnInitializedListener {

    var position = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_info)
        val bundle = intent.extras
        val ytPlayerView = findViewById<YouTubePlayerView>(R.id.YouTubePlayerWidget)

        // Retrieving values from bundle
        tvEventPageTitle.text = bundle?.getString("EventTitle")
        tvEventPageDate.text = bundle?.getString("EventDate")?.let { date(it) }
        tvEventDescription.text = bundle?.getString("EventDesc")
        YOUTUBE_VIDEO_LINK = bundle?.getString("EventYtVideoLink")
        organizer.text = bundle?.getString("EventOrg")
        Picasso.get().load(bundle?.getString("EventImage")).into(ivEventBanner)
        ImageHandler().getSharedInstance(applicationContext)
            ?.load(bundle?.getString("EventImage"))?.into(ivEventBanner)
        position = intent.getIntExtra("Position", 0)
        val url = bundle?.getString("EventUrl")
        if (position == 1 || position == 3) {
            registerEventButton.visibility = View.GONE
            Handler(Looper.myLooper()!!).postDelayed(
                {
                    ytPlayerView.initialize(getString(R.string.YOUTUBE_API_KEY), this)
                }, 500
            )
        }
        registerEventButton.setOnClickListener {
            if (url != null) {
                val builder = CustomTabsIntent.Builder()
                builder.setToolbarColor(getColor(R.color.BottomNavBg))
                val customTabsIntent = builder.build()
                customTabsIntent.launchUrl(this, Uri.parse(url))
            }
        }
        if (position == 2) {
            ytPlayerView.visibility = View.GONE
        }

        // YouTube Player

    }

    private fun date(date: String): String {
        val inputFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val outputFormat = SimpleDateFormat("EEE, dd MMM yy", Locale.getDefault())
        val datetext: Date
        var str: String? = null
        try {
            datetext = inputFormat.parse(date)
            str = outputFormat.format(datetext)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return str.toString()
    }

    // YouTubePlayer members
    override fun onInitializationSuccess(
        provider: YouTubePlayer.Provider?,
        youTubePlayer: YouTubePlayer?,
        wasRestored: Boolean
    ) {
        if (!wasRestored) {
            if (YOUTUBE_VIDEO_LINK != null)
                youTubePlayer?.cueVideo(getYouTubeVideoId(YOUTUBE_VIDEO_LINK!!))
            else
                Toast.makeText(this, "Video not available!", Toast.LENGTH_SHORT).show()
        } else {
            youTubePlayer?.play()
        }
    }

    override fun onInitializationFailure(
        provider: YouTubePlayer.Provider?,
        youTubeInitializationResult: YouTubeInitializationResult?
    ) {
        val REQUEST_CODE = 0
        if (youTubeInitializationResult?.isUserRecoverableError == true) {
            youTubeInitializationResult.getErrorDialog(this, REQUEST_CODE).show()
        } else {
            val errorMessage = "Error initializing YouTube Player: $youTubeInitializationResult"
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
        }
    }

    private fun getYouTubeVideoId(youTubeVideoLink: String): String {
        val youTubeVideoId = youTubeVideoLink.split("=")
        Log.d(TAG, "getYouTubeVideoId: youTubeVideoId: ${youTubeVideoId[1]}")
        return youTubeVideoId[1]
    }


}