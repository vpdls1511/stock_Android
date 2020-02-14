package com.ngyu.stock

import android.transition.ChangeClipBounds
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ngyu.stock.fragments.AverageFragment
import com.ngyu.stock.fragments.ContinuityFragment
import com.ngyu.stock.fragments.CostFragment
import com.ngyu.stock.fragments.RevenueFragment

class ViewPagerAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm) {

    val PAGE_MAX_CNT = 4

    override fun getCount(): Int {
        return PAGE_MAX_CNT
    }

    override fun getItem(position: Int): Fragment? {
        val fragment = when(position)
        {
            1 -> AverageFragment().newInstance()
            2 -> ContinuityFragment().newInstance()
            3 -> CostFragment().newInstance()
            else -> RevenueFragment().newInstance()
        }
        return fragment
    }

    override fun getPageTitle(position: Int) : CharSequence? {
        val title = when(position){

            1 -> "평단가"
            2 -> "상/하한가"
            3 -> "매도/매수"
            else -> "수익률"
        }

        return title
    }

}