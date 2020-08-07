package com.bvpieee.ui.events

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bvpieee.EventWebView
import com.bvpieee.R
import com.bvpieee.utils.toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_event_info.*

class EventInfoPage : AppCompatActivity() {

    var position = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_info)

        tvEventPageTitle.text = intent.getStringExtra("EventTitle")
        tvEventPageDate.text = intent.getStringExtra("EventDate")
        tvEventDescription.text = intent.getStringExtra("EventDesc")
        organizer.text = intent.getStringExtra("EventOrg")
        Picasso.get().load(intent.getStringExtra("EventImage")).into(ivEventBanner)
        position = intent.getIntExtra("Position",0)
        toast(position.toString())
        val url = intent.getStringExtra("EventUrl")
        registerEventButton.setOnClickListener {
            val intent = Intent(this, EventWebView::class.java)
            if (url!=null)
                intent.putExtra("url",url)
            startActivity(intent)
        }
    }
}