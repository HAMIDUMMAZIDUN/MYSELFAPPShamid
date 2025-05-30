package com.example.uts10122038hamidabdulaziz.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uts10122038hamidabdulaziz.R
import com.example.uts10122038hamidabdulaziz.data.model.InterestData

class InterestAdapter(private val interests: List<InterestData>) :
    RecyclerView.Adapter<InterestAdapter.InterestViewHolder>() {

    class InterestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        private val rvItems: RecyclerView = itemView.findViewById(R.id.rvItems)

        fun bind(interest: InterestData) {
            tvTitle.text = interest.title

            // Set up the nested RecyclerView for items
            rvItems.layoutManager = LinearLayoutManager(itemView.context)
            rvItems.adapter = InterestItemAdapter(interest.items)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InterestViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_interest, parent, false)
        return InterestViewHolder(view)
    }

    override fun onBindViewHolder(holder: InterestViewHolder, position: Int) {
        holder.bind(interests[position])
    }

    override fun getItemCount(): Int = interests.size
}