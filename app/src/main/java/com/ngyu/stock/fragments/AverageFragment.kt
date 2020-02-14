package com.ngyu.stock.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.ngyu.stock.R
import kotlinx.android.synthetic.main.average_stock.*
import kotlinx.android.synthetic.main.average_stock.view.*
import java.text.DecimalFormat
import kotlin.math.log

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


                    val num1: Int = Integer.parseInt(until_pirce1.text.toString())
                    val num2: Int = Integer.parseInt(quantity1.text.toString())
                    val num3: Int = Integer.parseInt(until_pirce2.text.toString())
                    val num4: Int = Integer.parseInt(quantity2.text.toString())


                    val result = ((num1 * num2) + (num3 * num4)) / (num2 + num4)
                    val comma = makeCommaNumber(result)
                    averagePrice.setText(comma.toString() + " 원")
                }
            })

        return v
    }

    fun makeCommaNumber(input:Int):String{
        val fomatter = DecimalFormat("###,###")
        return fomatter.format(input)
    }

}