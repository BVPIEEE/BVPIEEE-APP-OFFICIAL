package com.bvpieee.ui.events

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bvpieee.R
import com.bvpieee.adapters.EventsAdapter
import com.bvpieee.models.EventInfo
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_events.*
import java.util.*

class EventsFragment : Fragment() {

    private var rvEvents: RecyclerView? = null
    var firebaseDatabase = FirebaseDatabase.getInstance()
    var databaseReference: DatabaseReference? = null
    private var eventList: ArrayList<EventInfo>? = null
//    private lateinit var addValueEventListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_events, container, false)
        rvEvents = root.findViewById(R.id.rvEvents)
        eventList = ArrayList()
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

                        val info =
                            EventInfo(name!!, date!!, dept!!, desc!!,image!!, url)
                        eventList!!.add(info)
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