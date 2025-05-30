package com.example.uts10122038hamidabdulaziz.ui.music

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uts10122038hamidabdulaziz.R
import com.example.uts10122038hamidabdulaziz.data.dummy.DummyData
import com.example.uts10122038hamidabdulaziz.ui.music.adapter.MusicAdapter
import com.example.uts10122038hamidabdulaziz.ui.music.adapter.VideoAdapter

class MusicFragment : Fragment() {

    private lateinit var rvMusic: RecyclerView
    private lateinit var rvVideos: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_music, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize RecyclerViews
        rvMusic = view.findViewById(R.id.rvMusic)
        rvVideos = view.findViewById(R.id.rvVideos)

        // Set up favorite music
        setupFavoriteMusic()

        // Set up favorite videos
        setupFavoriteVideos()
    }

    private fun setupFavoriteMusic() {
        val musicList = DummyData.getFavoriteMusic()

        rvMusic.layoutManager = LinearLayoutManager(requireContext())
        rvMusic.adapter = MusicAdapter(musicList) { music ->
            // Handle music item click
            showToast("Playing: ${music.title} by ${music.artist}")
        }
    }

    private fun setupFavoriteVideos() {
        val videoList = DummyData.getFavoriteVideos()

        rvVideos.layoutManager = LinearLayoutManager(requireContext())
        rvVideos.adapter = VideoAdapter(videoList) { video ->
            // Handle video item click
            showToast("Playing video: ${video.title}")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}