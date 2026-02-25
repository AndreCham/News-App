package com.example.lab1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv: RecyclerView = findViewById(R.id.newsRecyclerView)
        rv.layoutManager = LinearLayoutManager(this)


// A list of standard Android icons we can use for free
        val defaultImages = listOf(
            android.R.drawable.ic_menu_camera,
            android.R.drawable.ic_menu_gallery,
            android.R.drawable.ic_menu_mapmode,
            android.R.drawable.ic_menu_send
        )

        val newsList = List<NewsItem>(10) { index ->
            NewsItem(
                title = "Breaking News #${index + 1}",
                description = "This is a unique summary for news story number ${index + 1}.",
                // This math loops through the 4 images over and over
                imageResId = defaultImages[index % defaultImages.size]
            )
        }



        rv.adapter = NewsAdapter(newsList)
    }
}