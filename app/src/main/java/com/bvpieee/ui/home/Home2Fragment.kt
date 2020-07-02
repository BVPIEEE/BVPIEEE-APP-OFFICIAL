package com.bvpieee.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bvpieee.R
import com.bvpieee.adapters.ChapterPagerAdapter
import com.saeed.infiniteflow.lib.FinitePagerContainer


class Home2Fragment : Fragment() {

    private val recyclerPagerAdapter: ChapterPagerAdapter by lazy {
        ChapterPagerAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_home2, container, false)

        val pagerContainer = view.findViewById<FinitePagerContainer>(R.id.pager_container)
    // Set Your Adapter with viewPager adapter
        pagerContainer.getViewPager().adapter = recyclerPagerAdapter
        pagerContainer.getViewPager().offscreenPageLimit = 4
        pagerContainer.setSimpleSlider(
            unSelectedItemRotation = 0f,    // Rotation of Unselected Items
            unSelectedItemAlpha = 0.2f,     // Alpha Value of unselected Items
            minScale = 0.5f                 // Min Scale on unselected Items
        )

        return view
    }


}