package com.ngyu.stock.ui.fragments.revenues

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ngyu.stock.R
import com.ngyu.stock.module.makeCommaNumberInt
import kotlinx.android.synthetic.main.revenue_stock_2.*
import kotlinx.android.synthetic.main.revenue_stock_2.view.*

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


        v.goalRevenue.addTextChangedListener(object : TextWatcher {
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