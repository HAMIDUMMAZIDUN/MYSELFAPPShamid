package com.example.uts10122038hamidabdulaziz.ui.daily.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.uts10122038hamidabdulaziz.R
import com.example.uts10122038hamidabdulaziz.data.model.FriendData
import de.hdodenhof.circleimageview.CircleImageView

class FriendsAdapter(
    private val friends: List<FriendData>,
    private val onItemClickListener: (FriendData) -> Unit
) : RecyclerView.Adapter<FriendsAdapter.FriendViewHolder>() {

    class FriendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imgFriend: CircleImageView = itemView.findViewById(R.id.imgFriend)
        private val tvFriendName: TextView = itemView.findViewById(R.id.tvFriendName)

        fun bind(friend: FriendData, onItemClickListener: (FriendData) -> Unit) {
            imgFriend.setImageResource(friend.image)
            tvFriendName.text = friend.name

            itemView.setOnClickListener {
                onItemClickListener(friend)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_friend, parent, false)
        return FriendViewHolder(view)
    }

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        holder.bind(friends[position], onItemClickListener)
    }

    override fun getItemCount(): Int = friends.size
}