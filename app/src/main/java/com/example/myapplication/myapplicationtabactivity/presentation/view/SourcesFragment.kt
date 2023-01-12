package com.example.myapplication.myapplicationtabactivity.presentation.view

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
import com.example.myapplication.myapplicationtabactivity.databinding.FragmentSourcesBinding
import com.example.myapplication.myapplicationtabactivity.presentation.Util
import com.example.myapplication.myapplicationtabactivity.presentation.adapter.SourcesRecyclerViewAdapter
import com.example.myapplication.myapplicationtabactivity.presentation.viewmodel.ArticleDetailsViewModel


class SourcesFragment : Fragment() {

    private  lateinit var viewModel: ArticleDetailsViewModel
    private lateinit var sourcesAdapter: SourcesRecyclerViewAdapter
    private lateinit var binding: FragmentSourcesBinding
    private var country = "us"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_sources, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        sourcesAdapter = (activity as MainActivity).sourcesAdapter

        initRecyclerView()
        viewSourcesList()
    }

    private fun initRecyclerView() {
        sourcesAdapter = SourcesRecyclerViewAdapter()
        binding.rvNewsArticles.apply {
            adapter = sourcesAdapter
            layoutManager = LinearLayoutManager(activity)
            addItemDecoration(DividerItemDecoration(activity, LinearLayoutManager.VERTICAL))
        }
        sourcesAdapter.onItemClick = { sourceDetails ->
            Log.d(Util.TAG, " sourceDetails name is ${sourceDetails.name}")
            Log.d(Util.TAG, " sourceDetails check status is ${sourceDetails.isChecked}")
        }
    }

    private fun viewSourcesList() {
        binding.pbLoading.visibility = View.VISIBLE
        viewModel.getSources(country)
        viewModel.sourcesList.observe(viewLifecycleOwner) {
            if(it.sources.isNotEmpty()) {
                binding.rvNewsArticles.visibility = View.VISIBLE
                sourcesAdapter.sourcesList = it.sources
                sourcesAdapter.notifyDataSetChanged()
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