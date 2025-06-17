package com.example.theme_handle.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.theme_handle.R
import com.example.theme_handle.dummy_data.Story

class StoryAdapter(private val stories: List<Story>) :
    RecyclerView.Adapter<StoryAdapter.StoryViewHolder>() {

    inner class StoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val storyAvatarImageView: ImageView = itemView.findViewById(R.id.storyAvatarImageView)
        val storyUserNameTextView: TextView = itemView.findViewById(R.id.storyUserNameTextView)

        fun bind(story: Story) {
            storyAvatarImageView.setImageResource(story.avatarResId)
            storyUserNameTextView.text = story.userName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_story, parent, false)
        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        val story = stories[position]
        holder.bind(story)
    }

    override fun getItemCount(): Int {
        return stories.size
    }
}
