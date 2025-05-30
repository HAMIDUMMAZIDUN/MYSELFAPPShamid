package com.example.uts10122038hamidabdulaziz.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uts10122038hamidabdulaziz.R
import com.example.uts10122038hamidabdulaziz.data.dummy.DummyData
import com.example.uts10122038hamidabdulaziz.ui.home.adapter.InterestAdapter

class HomeFragment : Fragment() {

    private lateinit var imgProfile: ImageView
    private lateinit var tvName: TextView
    private lateinit var tvDescription: TextView
    private lateinit var tvFullDescription: TextView
    private lateinit var btnSeeMore: Button
    private lateinit var rvInterests: RecyclerView

    private var isDescriptionExpanded = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize views
        imgProfile = view.findViewById(R.id.imgProfile)
        tvName = view.findViewById(R.id.tvName)
        tvDescription = view.findViewById(R.id.tvDescription)
        tvFullDescription = view.findViewById(R.id.tvFullDescription)
        btnSeeMore = view.findViewById(R.id.btnSeeMore)
        rvInterests = view.findViewById(R.id.rvInterests)

        // Set up profile section
        setupProfile()

        // Set up interest section
        setupInterests()
    }

    private fun setupProfile() {
        val profileData = DummyData.getProfileData()

        imgProfile.setImageResource(profileData.photo)
        tvName.text = profileData.name

        // Show truncated description initially
        val shortDesc = if (profileData.description.length > 100) {
            profileData.description.substring(0, 100) + "..."
        } else {
            profileData.description
        }

        tvDescription.text = shortDesc
        tvFullDescription.text = profileData.description

        // Set up See More button functionality
        btnSeeMore.setOnClickListener {
            if (isDescriptionExpanded) {
                // Collapse the description
                tvDescription.visibility = View.VISIBLE
                tvFullDescription.visibility = View.GONE
                btnSeeMore.text = "See More"
            } else {
                // Expand the description
                tvDescription.visibility = View.GONE
                tvFullDescription.visibility = View.VISIBLE
                btnSeeMore.text = "See Less"
            }
            isDescriptionExpanded = !isDescriptionExpanded
        }
    }

    private fun setupInterests() {
        val interestData = DummyData.getInterestData()

        rvInterests.layoutManager = LinearLayoutManager(context)
        rvInterests.adapter = InterestAdapter(interestData)
    }
}