package com.bvpieee.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.bvpieee.R
import com.bvpieee.adapters.ChapterPagerAdapter
import com.saeed.infiniteflow.lib.FinitePagerContainer
import com.saeed.infiniteflow.lib.toPx


class Home2Fragment : Fragment() {

    private val titles = arrayOf("RAS", "IAS", "CS", "WIE", "HKN")
    private var animationStartNeeded = true

    private val recyclerPagerAdapter: ChapterPagerAdapter by lazy {
        ChapterPagerAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home2, container, false)

        val pagerContainer = view.findViewById<FinitePagerContainer>(R.id.pager_container)
        val text = view.findViewById<FinitePagerContainer>(R.id.title_text_view) as TextView
        val view_pager = view.findViewById<FinitePagerContainer>(R.id.view_pager) as ViewPager2
        text.text = titles[0]
//        title_text_view.text = titles[0]
        // Set Your Adapter with viewPager adapter
        pagerContainer.getViewPager().adapter = recyclerPagerAdapter
        pagerContainer.getViewPager().offscreenPageLimit = 4
        pagerContainer.setSimpleSlider(
            unSelectedItemRotation = 0f,    // Rotation of Unselected Items
            unSelectedItemAlpha = 0.2f,     // Alpha Value of unselected Items
            minScale = 0.5f                 // Min Scale on unselected Items
        )

        var targetPosition = 0f
        var targetAlpha = 1f
        view_pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

            override fun onPageScrollStateChanged(state: Int) {

                when (state) {
                    ViewPager2.SCROLL_STATE_IDLE -> {
                        animationStartNeeded = true
                        targetPosition = 0f
                        targetAlpha = 1f
                    }
                    else -> {
                        if (animationStartNeeded) {
                            animationStartNeeded = false
                            targetPosition = 20.toPx().toFloat()
                            targetAlpha = 0f
                        }
                    }
                }

                text.spring(DynamicAnimation.TRANSLATION_Y, targetPosition)
                text.spring(DynamicAnimation.ALPHA, targetAlpha)
                super.onPageScrollStateChanged(state)
            }

            override fun onPageSelected(position: Int) {
                text.text = titles[position]
                super.onPageSelected(position)
            }
        })

        return view
    }

    fun View.spring(property: DynamicAnimation.ViewProperty, value: Float) {
        val anim = SpringAnimation(this, property)
        val springForce = SpringForce()
        springForce.dampingRatio = SpringForce.DAMPING_RATIO_MEDIUM_BOUNCY
        springForce.stiffness = SpringForce.STIFFNESS_LOW
        anim.spring = springForce
        anim.animateToFinalPosition(value)
    }


}