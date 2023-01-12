package com.example.myapplication.myapplicationtabactivity.presentation.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.myapplicationtabactivity.R
import com.example.myapplication.myapplicationtabactivity.databinding.FragmentNewsArticlesBinding
import com.example.myapplication.myapplicationtabactivity.presentation.Util.Companion.KEY_ARTICLE
import com.example.myapplication.myapplicationtabactivity.presentation.Util.Companion.KEY_DB_SAVE_OPERATION
import com.example.myapplication.myapplicationtabactivity.presentation.Util.Companion.TAG
import com.example.myapplication.myapplicationtabactivity.presentation.adapter.NewsArticleRecyclerViewAdapter
import com.example.myapplication.myapplicationtabactivity.presentation.viewmodel.ArticleDetailsViewModel

class NewsArticlesFragment : Fragment() {

    private  lateinit var viewModel: ArticleDetailsViewModel
    private lateinit var newsAdapter: NewsArticleRecyclerViewAdapter
    private lateinit var binding: FragmentNewsArticlesBinding
    private var country = "us"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_news_articles, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //fragmentNewsBinding = FragmentNewsArticlesBinding.bind(view)
        viewModel = (activity as MainActivity).viewModel
        newsAdapter = (activity as MainActivity).newsAdapter

        initRecyclerView()
        viewNewsList()
    }

    private fun initRecyclerView() {
        newsAdapter = NewsArticleRecyclerViewAdapter()
        binding.rvNewsArticles.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
            addItemDecoration(DividerItemDecoration(activity, LinearLayoutManager.VERTICAL))
        }
        newsAdapter.onItemClick = { article ->
            Log.d(TAG, " article title is $article")
            val intent = Intent(activity, ArticleDetailsActivity::class.java)
            intent.putExtra(KEY_ARTICLE, article)
            intent.putExtra(KEY_DB_SAVE_OPERATION, true)
            startActivity(intent)
        }
    }

    private fun viewNewsList() {
        binding.pbLoading.visibility = View.VISIBLE

        viewModel.getNewsArticles(country)
        viewModel.newArticlesList.observe(viewLifecycleOwner) {
            if(it.articles.isNotEmpty()) {
                binding.rvNewsArticles.visibility = View.VISIBLE
                newsAdapter.newsList = it.articles
                newsAdapter.notifyDataSetChanged()
            } else {
                binding.rvNewsArticles.visibility = View.GONE
            }

            binding.pbLoading.visibility = View.GONE
        }

        viewModel.isError.observe(viewLifecycleOwner){
            if(it){
                binding.pbLoading.visibility = View.GONE
                Toast.makeText(activity, activity?.resources?.getText(R.string.error_message), Toast.LENGTH_SHORT).show()
            }
        }
    }
}