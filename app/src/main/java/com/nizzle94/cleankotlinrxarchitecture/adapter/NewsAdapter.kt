package com.nizzle94.cleankotlinrxarchitecture.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.nizzle94.cleankotlinrxarchitecture.R
import com.nizzle94.cleankotlinrxarchitecture.api.result.NewsResult
import com.nizzle94.cleankotlinrxarchitecture.databinding.NewsItemBinding
import com.nizzle94.cleankotlinrxarchitecture.model.News
import com.nizzle94.cleankotlinrxarchitecture.utils.bind

/**
 * Created by Khajiev Nizomjon on 23/01/2018.
 */
class NewsAdapter(
    var newsList: MutableList<News>,
    var clickListener: (News) -> Unit
) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {


    fun setData(list: List<News>) {
        if (!newsList.isEmpty()) {
            newsList.clear()
        }
        newsList.addAll(list)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): NewsViewHolder {
        val binding = parent?.bind<NewsItemBinding>(R.layout.news_item)
        return NewsViewHolder(binding!!)
    }

    override fun getItemCount(): Int = newsList.size

    override fun onBindViewHolder(holder: NewsViewHolder?, position: Int) {
        val news = newsList[position]
        holder?.bind(news, listener = clickListener)
    }


    class NewsViewHolder(private val binding: NewsItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(news: News, listener: (News) -> Unit) {
            binding.news = news
            binding.root.setOnClickListener { listener(news) }
        }
    }
}