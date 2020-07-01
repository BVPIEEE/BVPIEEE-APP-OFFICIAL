package com.bvpieee.models

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

object SavedPreference {
    const val EMAIL = "email"
    const val USERNAME = "username"

    private fun getSharedPreference(ctx:Context?): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(ctx)
    }

    private fun editor(context: Context, const:String, string: String){
         getSharedPreference(context).edit().putString(const,string).apply()
    }

    fun setEmail(context: Context, email:String){
        editor(context, EMAIL, email)
    }

    fun getEmail(context: Context) = getSharedPreference(context).getString(EMAIL,"")

    fun setUsername(context: Context, username:String){
        editor(context, USERNAME,username)
    }

    fun getUsername(context: Context) = getSharedPreference(context).getString(USERNAME,"")

}