package com.example.uts10122038hamidabdulaziz.ui.music.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.uts10122038hamidabdulaziz.R
import com.example.uts10122038hamidabdulaziz.data.model.VideoData

class VideoAdapter(
    private val videoList: List<VideoData>,
    private val onItemClick: (VideoData) -> Unit
) : RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {

    class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imgThumbnail: ImageView = itemView.findViewById(R.id.imgThumbnail)
        private val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        private val tvChannel: TextView = itemView.findViewById(R.id.tvChannel)
        private val tvDuration: TextView = itemView.findViewById(R.id.tvDuration)
        private val tvViews: TextView = itemView.findViewById(R.id.tvViews)

        fun bind(video: VideoData, onItemClick: (VideoData) -> Unit) {
            imgThumbnail.setImageResource(video.thumbnail)
            tvTitle.text = video.title
            tvChannel.text = video.channel
            tvDuration.text = video.duration
            tvViews.text = video.views

            itemView.setOnClickListener {
                onItemClick(video)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_video, parent, false)
        return VideoViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.bind(videoList[position], onItemClick)
    }

    override fun getItemCount(): Int = videoList.size
}