package com.ngyu.stock.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ngyu.stock.R
import com.ngyu.stock.module.makeCommaNumberInt
import kotlinx.android.synthetic.main.average_stock.*
import kotlinx.android.synthetic.main.average_stock.view.*


open class AverageFragment: Fragment()
{
    fun newInstance(): AverageFragment
    {
        val args = Bundle()

        val frag = AverageFragment()
        frag.arguments = args

        return frag
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val v = inflater.inflate(R.layout.average_stock, container, false)
            v.quantity2.addTextChangedListener(object : TextWatcher{
                override fun afterTextChanged(p0: Editable?) {}

                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {


                    var num1 = until_pirce1.text.toString()
                    var num2 = quantity1.text.toString()
                    var num3 = until_pirce2.text.toString()
                    var num4 = quantity2.text.toString()

                    if(num1==""){ num1 = "1" }
                    if(num2==""){ num2 = "1" }
                    if(num3==""){ num3 = "1" }
                    if(num4==""){ num4 = "1" }


                    val result = ((num1.toInt() * num2.toInt()) + (num3.toInt() * num4.toInt())) / (num2.toInt() + num4.toInt())
                    val comma = makeCommaNumberInt(result)
                    averagePrice.setText(comma.toString() + " 원")
                }
            })

        return v
    }



}