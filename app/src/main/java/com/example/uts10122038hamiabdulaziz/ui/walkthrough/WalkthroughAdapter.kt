package com.example.uts10122038hamidabdulaziz.ui.walkthrough

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView // ImageView tidak lagi digunakan
import androidx.recyclerview.widget.RecyclerView
import com.example.uts10122038hamidabdulaziz.R

class WalkthroughAdapter(private val walkthroughItems: List<WalkthroughItem>) :
    RecyclerView.Adapter<WalkthroughAdapter.WalkthroughViewHolder>() {

    inner class WalkthroughViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        private val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)

        fun bind(walkthroughItem: WalkthroughItem) {

            tvTitle.text = walkthroughItem.title
            tvDescription.text = walkthroughItem.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WalkthroughViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_walkthrough, parent, false) // Pastikan R.layout.item_walkthrough sudah sesuai (tanpa ImageView)
        return WalkthroughViewHolder(view)
    }

    override fun onBindViewHolder(holder: WalkthroughViewHolder, position: Int) {
        holder.bind(walkthroughItems[position])
    }

    override fun getItemCount(): Int = walkthroughItems.size
}

data class WalkthroughItem(

    val title: String,
    val description: String
)