package com.example.uts10122038hamidabdulaziz.ui.music.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.uts10122038hamidabdulaziz.R
import com.example.uts10122038hamidabdulaziz.data.model.MusicData

class MusicAdapter(
    private val musicList: List<MusicData>,
    private val onItemClick: (MusicData) -> Unit
) : RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {

    class MusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imgAlbumCover: ImageView = itemView.findViewById(R.id.imgAlbumCover)
        private val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        private val tvArtist: TextView = itemView.findViewById(R.id.tvArtist)
        private val tvDuration: TextView = itemView.findViewById(R.id.tvDuration)

        fun bind(music: MusicData, onItemClick: (MusicData) -> Unit) {
            imgAlbumCover.setImageResource(music.albumCover)
            tvTitle.text = music.title
            tvArtist.text = music.artist
            tvDuration.text = music.duration

            itemView.setOnClickListener {
                onItemClick(music)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_music, parent, false)
        return MusicViewHolder(view)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        holder.bind(musicList[position], onItemClick)
    }

    override fun getItemCount(): Int = musicList.size
}