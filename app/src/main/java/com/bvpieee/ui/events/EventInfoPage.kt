package com.bvpieee.ui.events

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import com.bvpieee.R
import com.bvpieee.utils.toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_event_info.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class EventInfoPage : AppCompatActivity() {

    var position = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_info)
        val bundle = intent.extras
        tvEventPageTitle.text = bundle?.getString("EventTitle")
        tvEventPageDate.text = bundle?.getString("EventDate")?.let { date(it) }
        tvEventDescription.text = bundle?.getString("EventDesc")
        organizer.text = bundle?.getString("EventOrg")
        Picasso.get().load(bundle?.getString("EventImage")).into(ivEventBanner)
        position = intent.getIntExtra("Position", 0)
        toast(position.toString())
        val url = bundle?.getString("EventUrl")
        registerEventButton.setOnClickListener {
            if (url != null) {
                val builder = CustomTabsIntent.Builder()
                builder.setToolbarColor(getColor(R.color.BottomNavBg))
                val customTabsIntent = builder.build()
                customTabsIntent.launchUrl(this, Uri.parse(url))
            }
        }
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
}