package com.example.lab1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter(private val data: List<NewsItem>) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    class NewsViewHolder(val row: View) : RecyclerView.ViewHolder(row) {
        val title: TextView = row.findViewById(R.id.newsTitle)
        val desc: TextView = row.findViewById(R.id.newsDescription)
        val image: ImageView = row.findViewById(R.id.newsImage) // 1. Find the ImageView
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {

        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(layout)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val item = data[position]
        holder.title.text = item.title
        holder.desc.text = item.description
        holder.image.setImageResource(item.imageResId) // 2. Set the actual image
    }

    override fun getItemCount(): Int = data.size
}