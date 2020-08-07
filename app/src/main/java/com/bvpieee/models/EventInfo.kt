package com.bvpieee.models

import java.io.Serializable

class EventInfo(val eventTitle: String, val eventDate: String, val eventDept: String, val eventDesc: String, val eventImage: String, val url: String?) : Serializable {



    override fun toString(): String {
        return """
            Event Title: $eventTitle
            Event Date: $eventDate
            Event Dept: $eventDept
            Event Desc: $eventDesc
            """.trimIndent()
    }
}