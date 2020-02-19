package com.ngyu.stock.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.gauravk.bubblenavigation.BubbleNavigationLinearView
import com.google.android.material.tabs.TabLayout
import com.ngyu.stock.R
import com.ngyu.stock.adapter.RevenueViewPagerAdpater

open class ContinuityFragment : Fragment()
{
    fun newInstance(): ContinuityFragment
    {
        val args = Bundle()

        val frag = ContinuityFragment()
        frag.arguments = args

        return frag
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val v = inflater.inflate(R.layout.continuity_stock, container, false)

        val viewPagerAdapter = RevenueViewPagerAdpater( childFragmentManager )
        val bubbleNavigationLinearView = v.findViewById<BubbleNavigationLinearView>(R.id.bottom_navigation_view_linear)
        val pager = v.findViewById<ViewPager>(R.id.revenuSub)

        pager.adapter = viewPagerAdapter
        pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {}

            override fun onPageSelected(position: Int) {
                bubbleNavigationLinearView.setCurrentActiveItem(position)
            }
        })

        return v
    }
}