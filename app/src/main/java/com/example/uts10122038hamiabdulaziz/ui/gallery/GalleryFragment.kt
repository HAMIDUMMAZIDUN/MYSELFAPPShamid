package com.example.uts10122038hamidabdulaziz.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uts10122038hamidabdulaziz.R
import com.example.uts10122038hamidabdulaziz.data.dummy.DummyData
import com.example.uts10122038hamidabdulaziz.ui.gallery.adapter.GalleryAdapter
import com.example.uts10122038hamidabdulaziz.ui.gallery.util.GridSpacingItemDecoration

class GalleryFragment : Fragment() {

    private lateinit var rvGallery: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_gallery, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize RecyclerView
        rvGallery = view.findViewById(R.id.rvGallery)

        // Set up gallery
        setupGallery()
    }

    private fun setupGallery() {
        val galleryItems = DummyData.getGalleryItems()

        // Set up GridLayoutManager with 2 columns
        val gridLayoutManager = GridLayoutManager(requireContext(), 2)
        rvGallery.layoutManager = gridLayoutManager

        // Add spacing decoration
        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.grid_spacing)
        rvGallery.addItemDecoration(GridSpacingItemDecoration(2, spacingInPixels, true))

        // Set adapter
        rvGallery.adapter = GalleryAdapter(galleryItems) { galleryItem ->
            // Handle item click
            showToast("Selected: ${galleryItem.title}")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}