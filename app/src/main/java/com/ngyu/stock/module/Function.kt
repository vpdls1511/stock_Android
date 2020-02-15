package com.ngyu.stock.module

import java.text.DecimalFormat

fun makeCommaNumberInt(input:Int):String{
    val fomatter = DecimalFormat("###,###")
    return fomatter.format(input)
}

fun makeCommaNumberDouble(input:Double):String{
    val fomatter = DecimalFormat("###,###.##")
    return fomatter.format(input)
}