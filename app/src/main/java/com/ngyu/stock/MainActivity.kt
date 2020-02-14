package com.ngyu.stock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.gms.ads.AdSize
import com.google.android.material.tabs.TabLayout
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class MainActivity : AppCompatActivity() {

    private lateinit var mAdView : AdView

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
