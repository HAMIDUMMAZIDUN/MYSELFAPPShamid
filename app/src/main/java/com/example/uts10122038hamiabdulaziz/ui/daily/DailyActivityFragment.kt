package com.example.uts10122038hamidabdulaziz.ui.daily

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
import com.example.uts10122038hamidabdulaziz.data.model.DailyActivityData
import com.example.uts10122038hamidabdulaziz.data.model.FriendData
import com.example.uts10122038hamidabdulaziz.ui.daily.adapter.DailyActivityAdapter
import com.example.uts10122038hamidabdulaziz.ui.daily.adapter.FriendsAdapter

class DailyActivityFragment : Fragment() {

    private lateinit var rvFriends: RecyclerView
    private lateinit var rvDailyActivities: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_daily_activity, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize views
        rvFriends = view.findViewById(R.id.rvFriends)
        rvDailyActivities = view.findViewById(R.id.rvDailyActivities)

        // Set up friends RecyclerView
        setupFriendsList()

        // Set up daily activities RecyclerView
        setupDailyActivities()
    }

    private fun setupFriendsList() {
        val friends = DummyData.getFriends()

        rvFriends.layoutManager = LinearLayoutManager(
            requireContext(), LinearLayoutManager.HORIZONTAL, false
        )

        rvFriends.adapter = FriendsAdapter(friends) { friend ->
            // Handle friend item click
            showToast("Friend selected: ${friend.name}")
        }
    }

    private fun setupDailyActivities() {
        val activities = DummyData.getDailyActivities()

        rvDailyActivities.layoutManager = LinearLayoutManager(requireContext())
        rvDailyActivities.adapter = DailyActivityAdapter(activities) { activity ->
            // Handle activity item click
            showToast("Activity selected: ${activity.title}")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}