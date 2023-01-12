package com.example.myapplication.myapplicationtabactivity.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.myapplicationtabactivity.data.model.SourceDetails
import com.example.myapplication.myapplicationtabactivity.databinding.ItemViewSourcesBinding

class SourcesRecyclerViewAdapter: RecyclerView.Adapter<SourcesRecyclerViewAdapter.ViewHolder>() {

    var sourcesList: List<SourceDetails> = emptyList()
    var onItemClick: ((SourceDetails) -> Unit)? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SourcesRecyclerViewAdapter.ViewHolder {
        return ViewHolder(
            ItemViewSourcesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: SourcesRecyclerViewAdapter.ViewHolder,
        position: Int) {
        val sourceDetails = sourcesList[position]
        holder.bind(sourceDetails)
    }

    override fun getItemCount() = sourcesList.size

    inner class ViewHolder(val binding: ItemViewSourcesBinding):
                RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {

                if(sourcesList[absoluteAdapterPosition].isChecked) {
                    binding.checkedTvSourceId.isChecked = false
                    sourcesList[absoluteAdapterPosition].isChecked = false
                } else {
                    binding.checkedTvSourceId.isChecked = true
                    sourcesList[absoluteAdapterPosition].isChecked = true
                }

                onItemClick?.invoke(sourcesList[absoluteAdapterPosition])
            }
        }

        fun bind(sourceDetails: SourceDetails){
            binding.apply {
                checkedTvSourceId.text = sourceDetails.name
            }
        }
    }
}
