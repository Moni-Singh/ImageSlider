package com.example.imageslider

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.bumptech.glide.Glide.init
import com.example.imageslider.R.id.*
import com.google.android.material.tabs.TabLayout
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager2: ViewPager2
    private lateinit var handler: Handler
    private lateinit var imageList:ArrayList<Int>
    private lateinit var adapter: ImageAdapter
     private lateinit var button: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         button = findViewById<Button>(R.id.gif)
        button.setOnClickListener {
            startActivity(Intent(this@MainActivity, Gif::class.java))
        }

        button = findViewById<Button>(R.id.Tablayout)
        button.setOnClickListener {
            startActivity(Intent(this@MainActivity, com.example.imageslider.TabLayout::class.java))
        }



        button = findViewById(recycler)
      button.setOnClickListener{
          startActivity(Intent(this@MainActivity,NestedRecyclerView::class.java))
      }

        init ()
        setUpTransformer()
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable, 2000)
            }
        })

    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable,2000)

    }

    private val runnable = Runnable{
        viewPager2.currentItem = viewPager2.currentItem + 1
    }
    private fun setUpTransformer(){
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(40))
        transformer.addTransformer{ page,position ->
            val  r = 1 -abs(position)
            page.scaleY = 0.85f + r * 0.14f
        }
        viewPager2.setPageTransformer(transformer)

    }

    private  fun init(){
        viewPager2 = findViewById(viewpager2)
        handler = Handler(Looper.myLooper()!!)
        imageList =  ArrayList()

        imageList.add(R.drawable.cat)
        imageList.add(R.drawable.coco)
        imageList.add(R.drawable.princes)
        imageList.add(R.drawable.story)



        adapter =  ImageAdapter(imageList,viewPager2)
        viewPager2.adapter =adapter
        viewPager2.offscreenPageLimit =3
        viewPager2.clipToPadding =false
        viewPager2.clipChildren=false
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
    }
}


