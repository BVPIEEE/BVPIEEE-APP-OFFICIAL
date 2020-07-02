package com.bvpieee.ui.animations

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.lottie.LottieAnimationView
import com.bvpieee.R
import com.bvpieee.ui.teams.TeamsFragment

class LottieFragment : Fragment() {

    val teamFrag = TeamsFragment()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_lottie, container, false)
        val animation = view.findViewById<LottieAnimationView>(R.id.team)
        animation.speed = 2.0F
        animation.addAnimatorUpdateListener {}

        val handler = Handler()
        val x = Runnable {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer,teamFrag)
                .addToBackStack(null)
                .commit()
        }
        handler.postDelayed(x, 2000)

        return view
    }

}