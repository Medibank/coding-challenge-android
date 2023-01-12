package com.example.myapplication.myapplicationtabactivity.presentation.view

import android.app.ProgressDialog.show
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
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.myapplicationtabactivity.R
import com.example.myapplication.myapplicationtabactivity.databinding.FragmentNewsArticlesBinding
import com.example.myapplication.myapplicationtabactivity.presentation.Util
import com.example.myapplication.myapplicationtabactivity.presentation.Util.Companion.TAG
import com.example.myapplication.myapplicationtabactivity.presentation.adapter.NewsArticleRecyclerViewAdapter
import com.example.myapplication.myapplicationtabactivity.presentation.viewmodel.ArticleDetailsViewModel

class SavedArticlesFragment : Fragment() {

    private  lateinit var viewModel: ArticleDetailsViewModel
    private lateinit var newsAdapter: NewsArticleRecyclerViewAdapter
    private lateinit var binding: FragmentNewsArticlesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_news_articles, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel= (activity as MainActivity).viewModel
        newsAdapter= (activity as MainActivity).newsAdapter

        initRecyclerView()
        viewSavedNewsList()
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
            intent.putExtra(Util.KEY_ARTICLE, article)
            intent.putExtra(Util.KEY_DB_SAVE_OPERATION, false)
            startActivity(intent)
        }

        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN,
            ItemTouchHelper.LEFT) {

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder): Boolean {
                    return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val article = newsAdapter.newsList[position]
                viewModel.deleteArticle(article)
                Toast.makeText(activity, resources.getString(R.string.article_deleted_message), Toast.LENGTH_SHORT).show()
            }
        }

        ItemTouchHelper(itemTouchHelperCallback).apply {
            attachToRecyclerView(binding.rvNewsArticles)
        }

    }

    private fun viewSavedNewsList() {
        viewModel.getSavedNews().observe(viewLifecycleOwner) {
            if(it.isNotEmpty()) {
                binding.rvNewsArticles.visibility = View.VISIBLE
                newsAdapter.newsList = it
                newsAdapter.notifyDataSetChanged()
            } else {
                binding.rvNewsArticles.visibility = View.GONE
            }
        }
    }
}