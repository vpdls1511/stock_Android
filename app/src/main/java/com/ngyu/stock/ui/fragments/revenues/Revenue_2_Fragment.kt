package com.ngyu.stock.ui.fragments.revenues

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ngyu.stock.R

open class Revenue_2_Fragment: Fragment()
{
    fun newInstance(): Revenue_2_Fragment
    {
        val args = Bundle()

        val frag = Revenue_2_Fragment()
        frag.arguments = args

        return frag
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val v = inflater.inflate(R.layout.revenue_stock_2, container, false)
        return v
    }
}