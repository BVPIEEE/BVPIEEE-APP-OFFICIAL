package com.bvpieee.models

import java.io.Serializable

class EventInfo(val eventTitle: String? = null, val eventDate: String? = null, val eventDept: String? = null, val eventDesc: String? = null, val eventImage: String? = null, val url: String? = null) : Serializable {



    override fun toString(): String {
        return """
            Event Title: $eventTitle
            Event Date: $eventDate
            Event Dept: $eventDept
            Event Desc: $eventDesc
            """.trimIndent()
    }
}