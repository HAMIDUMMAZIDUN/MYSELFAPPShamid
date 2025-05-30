package com.example.uts10122038hamidabdulaziz.ui.daily.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.uts10122038hamidabdulaziz.R
import com.example.uts10122038hamidabdulaziz.data.model.DailyActivityData

class DailyActivityAdapter(
    private val activities: List<DailyActivityData>,
    private val onItemClickListener: (DailyActivityData) -> Unit
) : RecyclerView.Adapter<DailyActivityAdapter.ActivityViewHolder>() {

    class ActivityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imgActivity: ImageView = itemView.findViewById(R.id.imgActivity)
        private val tvActivityTitle: TextView = itemView.findViewById(R.id.tvActivityTitle)
        private val tvActivityDescription: TextView = itemView.findViewById(R.id.tvActivityDescription)
        private val tvActivityTime: TextView = itemView.findViewById(R.id.tvActivityTime)

        fun bind(activity: DailyActivityData, onItemClickListener: (DailyActivityData) -> Unit) {
            imgActivity.setImageResource(activity.image)
            tvActivityTitle.text = activity.title
            tvActivityDescription.text = activity.description
            tvActivityTime.text = activity.time

            itemView.setOnClickListener {
                onItemClickListener(activity)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_daily_activity, parent, false)
        return ActivityViewHolder(view)
    }

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        holder.bind(activities[position], onItemClickListener)
    }

    override fun getItemCount(): Int = activities.size
}