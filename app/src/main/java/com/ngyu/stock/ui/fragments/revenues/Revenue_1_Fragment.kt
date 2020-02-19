package com.ngyu.stock.ui.fragments.revenues

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ngyu.stock.R
import com.ngyu.stock.module.makeCommaNumberDouble
import kotlinx.android.synthetic.main.revenue_stock_1.*
import kotlinx.android.synthetic.main.revenue_stock_1.view.*

open class Revenue_1_Fragment: Fragment()
{
    fun newInstance(): Revenue_1_Fragment
    {
        val args = Bundle()

        val frag = Revenue_1_Fragment()
        frag.arguments = args

        return frag
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val v = inflater.inflate(R.layout.revenue_stock_1, container, false)

        v.until_price2.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, count: Int) {
                var num1 = until_pirce1.text.toString()
                var num3 = until_price2.text.toString()

                if(num1 == ""){ num1 = "1" }
                if(num3 == ""){ num3 = "1" }

                val revenue = ((num1.toDouble() / num3.toDouble())-1)*100

                revenuPrice.setText(makeCommaNumberDouble(revenue).toString() + "%")
            }
        })

        return v
    }
}