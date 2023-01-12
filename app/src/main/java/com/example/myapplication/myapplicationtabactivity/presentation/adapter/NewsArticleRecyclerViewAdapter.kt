package com.example.myapplication.myapplicationtabactivity.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.myapplicationtabactivity.data.model.Article
import com.example.myapplication.myapplicationtabactivity.databinding.ItemViewSavedArticleBinding
import com.example.myapplication.myapplicationtabactivity.presentation.Util.Companion.TAG

class NewsArticleRecyclerViewAdapter: RecyclerView.Adapter<NewsArticleRecyclerViewAdapter.ViewHolder>() {

    var newsList: List<Article> = emptyList()
    var onItemClick: ((Article) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemViewSavedArticleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val newsArticle = newsList[position]
        holder.bind(newsArticle)
    }

    override fun getItemCount(): Int = newsList.size

    inner class ViewHolder(val binding: ItemViewSavedArticleBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(newsList[absoluteAdapterPosition])
            }
        }

        fun bind(article: Article){
            binding.apply {
                tvTitle.text = article.title
                tvDescription.text = article.description
                tvAuthor.text = article.author

                Glide.with(ivArticleImage.context).
                load(article.urlToImage).
                into(ivArticleImage)
            }
        }
    }
}