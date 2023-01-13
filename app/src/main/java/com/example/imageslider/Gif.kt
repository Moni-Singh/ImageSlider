package com.example.imageslider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide

class Gif : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gif)
        showGIF()
    }

    // add code to animate gif image.
    fun showGIF() {
        val imageView: ImageView = findViewById(R.id.imageView)
        Glide.with(this).load(R.drawable.gifpng).into(imageView)
    }
}
