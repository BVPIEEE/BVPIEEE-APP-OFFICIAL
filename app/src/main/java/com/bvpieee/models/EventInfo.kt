package com.bvpieee.models

import java.io.Serializable

val eventList: ArrayList<EventInfo> = arrayListOf(
    EventInfo("CS", "1"),
    EventInfo("RAS", "2"),
    EventInfo("IAS", "3"),
    EventInfo("DRISHTI", "4"),
    EventInfo("GAMMA", "5"),
    EventInfo("BQC", "6")
)

class EventInfo(val eventTitle: String, val eventDate: String) : Serializable {

    override fun toString(): String {
        return """
            Event Title: $eventTitle
            Event Date: $eventDate
            """.trimIndent()
    }
}