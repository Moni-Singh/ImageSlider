package com.example.imageslider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.imageslider.model.PagerAdapters
import com.example.imageslider.view.HomeFragment
import com.example.imageslider.view.NotificationFragment
import com.example.imageslider.view.SearchFragment
import com.google.android.material.tabs.TabLayout
class TabLayout : AppCompatActivity() {
    private lateinit var pToolbar: Toolbar
    private lateinit var pTabs:TabLayout
    private lateinit var ptitle:TextView
    private lateinit var pViewPager:ViewPager
    private lateinit var pagerAdapters: PagerAdapters
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout)
        //setting here tolbar
        pToolbar = findViewById(R.id.pToolBar)
        ptitle = findViewById(R.id.titleText)
        pTabs = findViewById(R.id.tabs)
        //settig here toolbar
        pToolbar.setTitle("")
        ptitle.setText("Its me moni ")
        setSupportActionBar(pToolbar)
        pViewPager = findViewById(R.id.myPagerView)
        pagerAdapters = PagerAdapters(supportFragmentManager)
       //setting fragment list
        pagerAdapters.addFragment(HomeFragment(),"")
        pagerAdapters.addFragment(SearchFragment(),"")
        pagerAdapters.addFragment(NotificationFragment(),"")
        ///setting view page adapter
        pViewPager.adapter = pagerAdapters
       //setting the tab
        pTabs.setupWithViewPager(pViewPager)
       //adding icon here
        pTabs.getTabAt(0)!!.setIcon(R.drawable.ic_home_24)
        pTabs.getTabAt(1)!!.setIcon(R.drawable.ic_search_24)
        pTabs.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_notifications_24)
    }


}