package com.bvpieee.adapters

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.app.ActivityOptionsCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.core.util.Pair
import androidx.recyclerview.widget.RecyclerView
import com.bvpieee.R
import com.bvpieee.models.EventInfo
import com.bvpieee.ui.events.EventInfoPage
import com.bvpieee.utils.ImageHandler
import com.facebook.shimmer.ShimmerFrameLayout
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class EventsAdapter(val eventDataSet: ArrayList<EventInfo>, val context: Context, val c: Int) :
    RecyclerView.Adapter<EventsAdapter.ViewHolder>() {

    private val TAG = "EventsAdapter"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.events_grid_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvEventTitle.text = eventDataSet[position].name
        holder.tvEventDate.text = eventDataSet[position].date?.let { date(it) }
        val target = object : Target {
            override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
                holder.tvEventImage.setImageBitmap(bitmap)
                holder.shimmer.stopShimmer()
            }

            override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
                Toast.makeText(context, e?.message, Toast.LENGTH_SHORT).show()
            }

            override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
                    holder.shimmer.startShimmer()
            }

        }
//        Picasso.get().load(eventDataSet[position].eventImage).networkPolicy(NetworkPolicy.OFFLINE).into(holder.tvEventImage)
        ImageHandler().getSharedInstance(context.applicationContext)
            ?.load(eventDataSet[position].image)?.networkPolicy(NetworkPolicy.OFFLINE)?.into(target)
        holder.tvEventImage.tag = target
        holder.cvEvent.setOnClickListener {

            val intent = Intent(it.context, EventInfoPage::class.java)
            val bundle = Bundle().apply {
                putString("EventTitle", eventDataSet[position].name)
                putString("EventDate", eventDataSet[position].date)
                putString("EventDesc", eventDataSet[position].description)
                putString("EventOrg", eventDataSet[position].department)
                putString("EventImage", eventDataSet[position].image)
                putString("EventUrl", eventDataSet[position].url)
                putString("EventYtVideoLink", eventDataSet[position].videoLink)
                putInt("Position", c)

            }
            intent.putExtras(bundle)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                context as Activity,
                Pair.create(holder.tvEventTitle, "eventTitleTransition"),
                Pair.create(holder.tvEventDate, "eventDateTransition"),
                Pair.create(holder.tvEventImage, "eventBannerTransition")
            )
            startActivity(it.context, intent, options.toBundle())
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

    override fun getItemCount(): Int {
        return eventDataSet.size
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val tvEventTitle: TextView = v.findViewById(R.id.tvEventTitle)
        val tvEventDate: TextView = v.findViewById(R.id.tvEventDate)
        val tvEventImage: ImageView = v.findViewById(R.id.ivEventBannerCardImage)
        val cvEvent: CardView = v.findViewById(R.id.cvEvent)

        //        val progress: ProgressBar = v.findViewById(R.id.progressCard)
        val shimmer: ShimmerFrameLayout = v.findViewById(R.id.ivEventBannerCard)
    }


}