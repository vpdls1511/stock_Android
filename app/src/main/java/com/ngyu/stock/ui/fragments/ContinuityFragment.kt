package com.ngyu.stock.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.gauravk.bubblenavigation.BubbleNavigationLinearView
import com.google.android.material.tabs.TabLayout
import com.ngyu.stock.R
import com.ngyu.stock.adapter.RevenueViewPagerAdpater
import com.ngyu.stock.module.makeCommaNumberInt
import kotlinx.android.synthetic.main.continuity_stock.*
import kotlinx.android.synthetic.main.continuity_stock.view.*
import java.util.stream.IntStream.range

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

        var radioValue = 0
        val radioGroup: RadioGroup = v.findViewById(R.id.radioGroup)

        radioGroup.setOnCheckedChangeListener{group, checkedId ->
            val radioButton:RadioButton = v.findViewById(checkedId)

            if(radioButton.text == "연속 상한가"){
                radioValue = 1
                percentStock.hint = "상한률"
            }else if(radioButton.text == "연속 하한가"){
                radioValue = 0
                percentStock.hint = "하한률"
            }
        }

        v.repeatCount.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                var price = until_pirce1.text.toString()
                var repeat = repeatCount.text.toString()
                var percent = percentStock.text.toString()

                if (price == "") { price = "1" }
                if (percent == "") { percent = "1" }
                if (repeat == "") { repeat = "0" }

                var price2:Int = Integer.parseInt(price)

                if(radioValue == 1){
                    for(i in 0..repeat.toInt() ){
                        price2 += (price2.toDouble() * (percent.toDouble()/100.0)).toInt()
                        result.text = makeCommaNumberInt(price2).toString() + " 원"
                    }
                }else if(radioValue == 0){
                    for(i in 0..repeat.toInt() ){
                        price2 -= (price2.toDouble() * (-percent.toDouble()/100.0)).toInt()
                        result.text = "-"+makeCommaNumberInt(price2).toString() + " 원"
                    }
                }else{
                    repeatCount.setText("")
                    result.setText("연속 상/하한가 선택을 해 주세요.")
                }



            }

        })





        return v
    }
}