package com.bvpieee.ui.events

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.bvpieee.R
import com.bvpieee.adapters.EventsAdapter
import com.bvpieee.models.EventInfo
import com.bvpieee.utils.Utils
import com.google.android.material.card.MaterialCardView
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import com.ismaeldivita.chipnavigation.ChipNavigationBar
import kotlinx.android.synthetic.main.fragment_events.*
import java.text.SimpleDateFormat
import java.util.*

class EventsFragment : Fragment() {

    lateinit var firebaseDatabase: FirebaseDatabase
    lateinit var databaseReference: DatabaseReference
    val eventList = arrayListOf<EventInfo>()
    var teams: String? = null
    lateinit var mcontext: Context
    lateinit var bottomNavigationView: ChipNavigationBar
    lateinit var materialCardView: MaterialCardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
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
        if (activity != null) {bottomNavigationView = requireActivity().findViewById(R.id.bottom_nav)
        materialCardView = requireActivity().findViewById(R.id.upcoming_event_button)
        materialCardView.visibility = View.GONE}
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loadData()
        eventSwipeLayout.setOnRefreshListener { loadData() }
    }

    private fun loadData() {
        var counter = 0
        eventSwipeLayout.isRefreshing = true
        firebaseDatabase = Utils.getDatabase()
        databaseReference = firebaseDatabase.getReference("Events")
        databaseReference.keepSynced(true)
        databaseReference.orderByChild("date").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                eventList.clear()
                val pattern = "dd/MM/yyyy"
                try {
                    for (data in snapshot.children) {
                        Log.d("Event", "onDataChange: in loop")
                        val map = data.getValue(EventInfo::class.java)
                        if (map != null) {
                            val date =
                                SimpleDateFormat(pattern, Locale.getDefault()).parse(map.date!!)

                            if (Date().before(date)) {
                                if (teams.isNullOrEmpty()) {
                                    eventList.add(map)
                                } else if (map.department.toString() == teams) {
                                    eventList.add(map)
                                }
                            }
                            if (Date().after(date)) {
                                val reference = map.image?.let {
                                    FirebaseStorage.getInstance().getReferenceFromUrl(it)
                                }
                                reference?.delete()?.addOnCompleteListener {
                                    val db = data.ref
                                    db.removeValue()
                                }
                            }
                        }
                    }
                    val adapter = EventsAdapter(eventList, mcontext)
                    rvEvents!!.layoutManager = GridLayoutManager(mcontext, 2)
                    rvEvents!!.adapter = adapter
                    eventSwipeLayout.isRefreshing = false
                } catch (ignored: Exception) {
                }
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