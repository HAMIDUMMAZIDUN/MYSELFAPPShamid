package com.example.uts10122038hamidabdulaziz.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uts10122038hamidabdulaziz.R // Pastikan R diimport dengan benar
import com.example.uts10122038hamidabdulaziz.data.dummy.DummyData
import com.example.uts10122038hamidabdulaziz.ui.home.adapter.InterestAdapter

class HomeFragment : Fragment() {

    private lateinit var imgProfile: ImageView
    private lateinit var tvName: TextView
    private lateinit var tvDescription: TextView
    private lateinit var tvFullDescription: TextView
    private lateinit var btnSeeMore: Button
    private lateinit var rvInterests: RecyclerView

    private var isDescriptionExpanded = false // Defaultnya false (deskripsi disingkat)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imgProfile = view.findViewById(R.id.imgProfile)
        tvName = view.findViewById(R.id.tvName)
        tvDescription = view.findViewById(R.id.tvDescription)
        tvFullDescription = view.findViewById(R.id.tvFullDescription) // Pastikan ID ini ada di XML
        btnSeeMore = view.findViewById(R.id.btnSeeMore)
        rvInterests = view.findViewById(R.id.rvInterests)

        val cardProfileView = view.findViewById<CardView>(R.id.cardProfile) // Pastikan ID ini ada di XML

        setupProfile()
        setupInterests()

        cardProfileView?.apply {
            alpha = 0f
            animate().alpha(1f).setDuration(1000).start()
        }
    }

    private fun setupProfile() {
        val profileData = DummyData.getProfileData()

        imgProfile.setImageResource(profileData.photo)
        tvName.text = profileData.name

         val shortDesc = if (profileData.description.length > 100) {
            profileData.description.substring(0, 100) + "..."
        } else {
            profileData.description
        }
        tvDescription.text = shortDesc
        tvFullDescription.text = profileData.description

        btnSeeMore.setOnClickListener {
            isDescriptionExpanded = !isDescriptionExpanded // 1. Balik state ekspansi
            updateDescriptionViewState()                   // 2. Perbarui tampilan UI
        }

        updateDescriptionViewState()
    }

    private fun setupInterests() {
        val interestData = DummyData.getInterestData()
        rvInterests.layoutManager = LinearLayoutManager(context) // Menggunakan 'context' dari Fragment
        rvInterests.adapter = InterestAdapter(interestData)
    }

    private fun updateDescriptionViewState() {
        if (isDescriptionExpanded) {
            // State: Deskripsi sedang ditampilkan penuh (expanded)
            tvDescription.visibility = View.GONE
            tvFullDescription.visibility = View.VISIBLE
            btnSeeMore.text = getString(R.string.see_less) // Tombol menjadi "Lihat lebih sedikit"
        } else {
            // State: Deskripsi sedang disingkat (collapsed)
            tvDescription.visibility = View.VISIBLE
            tvFullDescription.visibility = View.GONE
            btnSeeMore.text = getString(R.string.see_more) // Tombol menjadi "Lihat lainnya"
        }
    }
}