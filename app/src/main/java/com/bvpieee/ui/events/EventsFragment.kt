package com.bvpieee.ui.events

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bvpieee.R
import com.bvpieee.adapters.EventsAdapter
import com.bvpieee.models.EventInfo
import com.google.firebase.database.*
import java.util.*

class EventsFragment : Fragment() {

    private var rvEvents: RecyclerView? = null
    lateinit var eventSwipeLayout:SwipeRefreshLayout
    var firebaseDatabase = FirebaseDatabase.getInstance()
    var databaseReference: DatabaseReference? = null
    private var eventList: ArrayList<EventInfo>? = null
    var teams:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(arguments != null) {
            val bundle = arguments
            teams = bundle?.getString("TEAMS").toString()
            Toast.makeText(activity, teams, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_events, container, false)
        rvEvents = root.findViewById(R.id.rvEvents)
        eventList = ArrayList()
        eventSwipeLayout = root.findViewById(R.id.eventSwipeLayout)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        loadData()
        eventSwipeLayout.setOnRefreshListener { loadData() }
    }

    private fun loadData() {
        eventSwipeLayout.isRefreshing = true
        eventList!!.clear()

        databaseReference = firebaseDatabase.getReference("Events")
        databaseReference!!.addValueEventListener(object  : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (data in snapshot.children) {
                        Log.d("Event", "onDataChange: in loop")
                        val map =
                            data.value as Map<String, Any>?
                        val name = map!!["name"] as String?
                        val date = map["date"] as String?
                        val dept = map["department"] as String?
                        val desc = map["description"] as String?
                        val image = map["image"] as String?
                        val url = map["url"] as String?
                        Log.d("Deets", "onDataChange: $map")

                        if(teams == null) {
                            val info = EventInfo(name!!, date!!, dept!!, desc!!, image!!, url)
                            eventList!!.add(info)
                        }
                        else if(teams != null && dept == teams){
                            val info = EventInfo(name!!, date!!, dept, desc!!, image!!, url)
                            eventList!!.add(info)
                        }
                    }
                    val adapter = EventsAdapter(eventList!!)
                    rvEvents!!.layoutManager = GridLayoutManager(context, 2)
                    rvEvents!!.adapter = adapter
                    eventSwipeLayout.isRefreshing = false
                }

                override fun onCancelled(error: DatabaseError) {
                    eventSwipeLayout.isRefreshing = false
                }
            })
    }

}