package com.bvpieee.ui.events

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bvpieee.R
import kotlinx.android.synthetic.main.activity_event_info.*

class EventInfoPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_info)

        tvEventPageTitle.text = intent.getStringExtra("EventTitle")
        tvEventPageDate.text = intent.getStringExtra("EventDate")
    }
}