package com.ngyu.stock.ui.fragments

import android.net.sip.SipErrorCode
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ngyu.stock.R
import com.ngyu.stock.module.makeCommaNumberDouble
import com.ngyu.stock.module.makeCommaNumberInt
import kotlinx.android.synthetic.main.revenue_stock.*
import kotlinx.android.synthetic.main.revenue_stock.until_pirce1
import kotlinx.android.synthetic.main.revenue_stock.view.*
import org.w3c.dom.Text

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

        v.goalRevenue.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                var num1 = until_price3.text.toString()
                var num2 = quantity1.text.toString()

                if (num1 == "") { num1 = "1" }
                if (num2 == "") { num2 = "1" }

                var num3 = goalRevenue.text.toString()
                if (num3 == "") { num3 = "1" }

                val goalprice = num3.toDouble()/100
                val sellResult = ( goalprice * num1.toDouble() ).toInt() + num1.toInt()
                val profitResult = (sellResult*num2.toInt()) - (num1.toInt() * num2.toInt())

                sellText.setText("매도가 : " + makeCommaNumberInt(sellResult) + " 원")
                profitText.setText("총이익 : " + makeCommaNumberInt(profitResult) + " 원")

            }
        })

        return v
    }
}