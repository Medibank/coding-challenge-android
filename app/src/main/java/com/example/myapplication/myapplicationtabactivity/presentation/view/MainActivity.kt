package com.example.myapplication.myapplicationtabactivity.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.myapplicationtabactivity.R
import com.example.myapplication.myapplicationtabactivity.databinding.ActivityMainBinding
import com.example.myapplication.myapplicationtabactivity.presentation.adapter.NewsArticleRecyclerViewAdapter
import com.example.myapplication.myapplicationtabactivity.presentation.adapter.SourcesRecyclerViewAdapter
import com.example.myapplication.myapplicationtabactivity.presentation.adapter.SectionsPagerAdapter
import com.example.myapplication.myapplicationtabactivity.presentation.viewmodel.ArticleDetailsViewModel
import com.example.myapplication.myapplicationtabactivity.presentation.viewmodel.MyViewModelFactory
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MyViewModelFactory
    @Inject
    lateinit var newsAdapter: NewsArticleRecyclerViewAdapter

    @Inject
    lateinit var sourcesAdapter: SourcesRecyclerViewAdapter

    lateinit var viewModel: ArticleDetailsViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val sectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager, lifecycle)
        val viewPager: ViewPager2 = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter

        TabLayoutMediator(binding.tabs, viewPager) { tab, position ->
            tab.text = resources.getStringArray(R.array.tab_title_array)[position]
        }.attach()

        viewModel = ViewModelProvider(this,factory).get(ArticleDetailsViewModel::class.java)
    }
}