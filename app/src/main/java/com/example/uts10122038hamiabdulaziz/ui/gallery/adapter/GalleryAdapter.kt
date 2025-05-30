package com.example.uts10122038hamidabdulaziz.ui.gallery.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.uts10122038hamidabdulaziz.R
import com.example.uts10122038hamidabdulaziz.data.model.GalleryItem

class GalleryAdapter(
    private val galleryItems: List<GalleryItem>,
    private val onItemClick: (GalleryItem) -> Unit
) : RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>() {

    class GalleryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imgGallery: ImageView = itemView.findViewById(R.id.imgGallery)
        private val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)

        fun bind(galleryItem: GalleryItem, onItemClick: (GalleryItem) -> Unit) {
            imgGallery.setImageResource(galleryItem.imageRes)
            tvTitle.text = galleryItem.title

            itemView.setOnClickListener {
                onItemClick(galleryItem)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_gallery, parent, false)
        return GalleryViewHolder(view)
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        holder.bind(galleryItems[position], onItemClick)
    }

    override fun getItemCount(): Int = galleryItems.size
}