package com.bvpieee.ui.events

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.bvpieee.R
import com.bvpieee.adapters.EventsAdapter
import com.bvpieee.models.EventInfo
import com.bvpieee.utils.Utils
import com.google.android.material.card.MaterialCardView
import com.google.firebase.database.*
import com.ismaeldivita.chipnavigation.ChipNavigationBar
import kotlinx.android.synthetic.main.fragment_events.*
import java.text.SimpleDateFormat
import java.util.*

class EventsFragment : Fragment() {

    lateinit var firebaseDatabase: FirebaseDatabase
    lateinit var databaseReference: DatabaseReference
    val upcomingEventList = arrayListOf<EventInfo>()
    val liveEventList = arrayListOf<EventInfo>()
    val pastEventList = arrayListOf<EventInfo>()
    var teams: String? = null
    lateinit var mcontext: Context
    lateinit var bottomNavigationView: ChipNavigationBar
    lateinit var materialCardView: MaterialCardView
    val TAG = "EventFragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            val bundle = arguments
            teams = bundle?.getString("TEAMS").toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_events, container, false)
        if (activity != null) {
            bottomNavigationView = requireActivity().findViewById(R.id.bottom_nav)
            materialCardView = requireActivity().findViewById(R.id.upcoming_event_button)
            materialCardView.visibility = View.GONE
        }
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loadData()
        eventSwipeLayout.setOnRefreshListener { loadData() }
    }

    private fun loadData() {
//        eventSwipeLayout.isRefreshing = true
        firebaseDatabase = Utils.getDatabase()
        databaseReference = firebaseDatabase.getReference("Events")
        databaseReference.keepSynced(true)
        databaseReference.orderByChild("date").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                upcomingEventList.clear()
                pastEventList.clear()
                liveEventList.clear()
                val pattern = "dd/MM/yyyy"
                try {
                    for (data in snapshot.children) {
                        Log.d("Event", "onDataChange: in loop")
                        val map = data.getValue(EventInfo::class.java)
                        if (map != null) {
                            val date =
                                SimpleDateFormat(pattern, Locale.getDefault()).parse(map.date!!)
                            val t = SimpleDateFormat(pattern, Locale.getDefault()).format(Date())
                            val today = SimpleDateFormat(pattern, Locale.getDefault()).parse(t)

                            if (today?.before(date)!! || (today == date && !map.live)) {
                                if (teams.isNullOrEmpty()) {
                                    upcomingEventList.add(map)
                                } else if (map.department.toString() == teams) {
                                    upcomingEventList.add(map)
                                }
                            }
                            if (today == date && map.live) {
                                if (teams.isNullOrEmpty()) {
                                    liveEventList.add(map)
                                } else if (map.department.toString() == teams) {
                                    liveEventList.add(map)
                                }
                            }
                            if (today.after(date)) {
                                if (teams.isNullOrEmpty()) {
                                    pastEventList.add(map)
                                } else if (map.department.toString() == teams) {
                                    pastEventList.add(map)
                                }
                            }
                        }
                    }
                    if (upcomingEventList.isNotEmpty())
                        upcomingEventsText.visibility = View.VISIBLE
                    if (liveEventList.isNotEmpty())
                        liveEventsText.visibility = View.VISIBLE
                    if (pastEventList.isNotEmpty())
                        pastEventsText.visibility = View.VISIBLE
                    val adapterLive = EventsAdapter(liveEventList, mcontext, 1)
                    val adapterUpcoming = EventsAdapter(upcomingEventList, mcontext, 2)
                    val adapterPast = EventsAdapter(pastEventList, mcontext, 3)
                    upcomingEvents.layoutManager = GridLayoutManager(mcontext, 2)
                    pastEvents.layoutManager = GridLayoutManager(mcontext, 2)
                    liveEvents.layoutManager = GridLayoutManager(mcontext, 2)
                    upcomingEvents.adapter = adapterUpcoming
                    pastEvents.adapter = adapterPast
                    liveEvents.adapter = adapterLive

                } catch (e: Exception) {
                    Log.d(TAG, "onDataChange: " + e.message)
                }
                eventSwipeLayout.isRefreshing = false
            }

            override fun onCancelled(error: DatabaseError) {
                eventSwipeLayout.isRefreshing = false
            }
        })
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mcontext = context
    }

}