package com.bvpieee.models

import java.io.Serializable

class EventInfo(
    val date: String? = null,
    val department: String? = null,
    val description: String? = null,
    val image: String? = null,
    val live: Boolean = false,
    val name: String? = null,
    val url: String? = null,
    val venue: String? = null,
    val videoLink: String? = null,

) : Serializable {

//    override fun toString(): String {
//        return """
//            Event Title: $eventTitle
//            Event Date: $eventDate
//            Event Dept: $eventDept
//            Event Desc: $eventDesc
//            """.trimIndent()
//    }
}