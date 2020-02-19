package com.ngyu.stock.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ngyu.stock.ui.fragments.revenues.Revenue_1_Fragment
import com.ngyu.stock.ui.fragments.revenues.Revenue_2_Fragment

class RevenueViewPagerAdpater (fm : FragmentManager) : FragmentPagerAdapter(fm) {

    val PAGE_MAX_CNT = 2

    override fun getCount(): Int {
        return PAGE_MAX_CNT
    }

    override fun getItem(position: Int): Fragment? {
        val fragment = when(position)
        {
            1 -> Revenue_2_Fragment().newInstance()
            else -> Revenue_1_Fragment().newInstance()
        }
        return fragment
    }

    override fun getPageTitle(position: Int) : CharSequence? {
        val title = when(position){

            1 -> "목표수익률"
            else -> "수익률"
        }

        return title
    }
}