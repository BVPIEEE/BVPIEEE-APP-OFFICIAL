package com.bvpieee.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bvpieee.HomeActivity
import com.bvpieee.R
import com.bvpieee.models.EventInfo

lateinit var homeActivityContextHolder: HomeActivity

class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val tvEventTitle: TextView = v.findViewById(R.id.tvEventTitle)
    val tvEventDate: TextView = v.findViewById(R.id.tvEventDate)
    val cvEvent: CardView = v.findViewById(R.id.cvEvent)
}

class EventsAdapter(val eventDataSet: ArrayList<EventInfo>) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View
        view = LayoutInflater.from(parent.context).inflate(R.layout.events_grid_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return eventDataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvEventTitle.text = eventDataSet[position].eventTitle
        holder.tvEventDate.text = eventDataSet[position].eventDate
        holder.cvEvent.setOnClickListener {
            TODO("Implement onClickListener for each view with SharedElementTransition")
        }
    }

//    companion object {
//        lateinit var homeActivityContextHolder: HomeActivity
//    }

}