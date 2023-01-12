package com.example.myapplication.myapplicationtabactivity.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.myapplicationtabactivity.presentation.view.NewsArticlesFragment
import com.example.myapplication.myapplicationtabactivity.presentation.view.SavedArticlesFragment
import com.example.myapplication.myapplicationtabactivity.presentation.view.SourcesFragment

class SectionsPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fm, lifecycle) {

    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> NewsArticlesFragment()
            1 -> SourcesFragment()
            else -> SavedArticlesFragment()
        }
    }
}