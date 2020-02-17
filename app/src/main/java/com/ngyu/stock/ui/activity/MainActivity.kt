package com.ngyu.stock.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.ngyu.stock.R
import com.ngyu.stock.adapter.ViewPagerAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        val pager = findViewById<ViewPager>(R.id.container)
        pager.adapter = viewPagerAdapter

        val tab = findViewById<TabLayout>(R.id.tab)
        tab.setupWithViewPager(pager)
    }
}
