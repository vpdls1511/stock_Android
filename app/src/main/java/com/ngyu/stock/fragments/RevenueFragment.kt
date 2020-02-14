package com.ngyu.stock.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ngyu.stock.R

open class RevenueFragment : Fragment()
{
    fun newInstance(): RevenueFragment
    {
        val args = Bundle()

        val frag = RevenueFragment()
        frag.arguments = args

        return frag
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val v = inflater.inflate(R.layout.revenue_stock, container, false)
        return v
    }
}