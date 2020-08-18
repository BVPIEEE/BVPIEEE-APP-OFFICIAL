package com.bvpieee.adapters

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.app.ActivityOptionsCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.core.util.Pair
import androidx.recyclerview.widget.RecyclerView
import com.bvpieee.R
import com.bvpieee.models.EventInfo
import com.bvpieee.ui.events.EventInfoPage
import com.squareup.picasso.Picasso


//lateinit var homeActivityContextHolder: HomeActivity

class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val tvEventTitle: TextView = v.findViewById(R.id.tvEventTitle)
    val tvEventDate: TextView = v.findViewById(R.id.tvEventDate)
    val tvEventImage: ImageView = v.findViewById(R.id.ivEventBannerCard)
    val cvEvent: CardView = v.findViewById(R.id.cvEvent)
}

class EventsAdapter(val eventDataSet: ArrayList<EventInfo>, val context: Context?) : RecyclerView.Adapter<ViewHolder>() {

    private val TAG = "EventsAdapter"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.d(TAG, ".onCreteViewHolder starts")
        val view: View
        view =
            LayoutInflater.from(parent.context).inflate(R.layout.events_grid_layout, parent, false)
        Log.d(TAG, ".onCreteViewHolder ends")
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return eventDataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG, ".onBlindViewHolder starts")
        holder.tvEventTitle.text = eventDataSet[position].eventTitle
        holder.tvEventDate.text = eventDataSet[position].eventDate
        Picasso.get().load(eventDataSet[position].eventImage).into(holder.tvEventImage)
        holder.cvEvent.setOnClickListener {

            val tvEventTitle: TextView = it.findViewById(R.id.tvEventTitle)
            val tvEventDate: TextView = it.findViewById(R.id.tvEventDate)
            val ivEventBanner: ImageView = it.findViewById(R.id.ivEventBannerCard)

            val intent = Intent(it.context, EventInfoPage::class.java)
            intent.putExtra("EventTitle", eventDataSet[position].eventTitle)
            intent.putExtra("EventDate", eventDataSet[position].eventDate)
            intent.putExtra("EventDesc", eventDataSet[position].eventDesc)
            intent.putExtra("EventOrg", eventDataSet[position].eventDept)
            intent.putExtra("EventImage", eventDataSet[position].eventImage)
            intent.putExtra("EventUrl", eventDataSet[position].url)
            intent.putExtra("Position",position)

            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                context as Activity,
                Pair.create<View, String>(tvEventTitle, "eventTitleTransition"),
                Pair.create<View, String>(tvEventDate, "eventDateTransition"),
                Pair.create<View, String>(ivEventBanner, "eventBannerTransition")
            )
            startActivity(it.context, intent, options.toBundle())
        }
        Log.d(TAG, ".onBlindViewHolder ends")
    }

//    companion object {
//        lateinit var homeActivityContextHolder: HomeActivity
//    }

}