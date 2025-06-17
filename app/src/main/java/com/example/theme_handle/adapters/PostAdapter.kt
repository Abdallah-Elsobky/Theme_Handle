package com.example.theme_handle.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.theme_handle.R
import com.example.theme_handle.dummy_data.Post

class PostAdapter(private val posts: List<Post>) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val postUserAvatarImageView: ImageView = itemView.findViewById(R.id.postUserAvatarImageView)
        val postUserNameTextView: TextView = itemView.findViewById(R.id.postUserNameTextView)
        val postTimeTextView: TextView = itemView.findViewById(R.id.postTimeTextView)
        val postImageView: ImageView = itemView.findViewById(R.id.postImageView)
        val postDescriptionTextView: TextView = itemView.findViewById(R.id.postDescriptionTextView)
        val likeCountTextView: TextView = itemView.findViewById(R.id.likeCountTextView)
        val commentCountTextView: TextView = itemView.findViewById(R.id.commentCountTextView)

        fun bind(post: Post) {
            postUserAvatarImageView.setImageResource(post.userAvatarResId)
            postUserNameTextView.text = post.userName
            postTimeTextView.text = post.postTime
            postImageView.setImageResource(post.postImageResId)
            postDescriptionTextView.text = post.postDescription
            likeCountTextView.text = buildString {
                append(post.likeCount)
                append(" Likes")
            }
            commentCountTextView.text = buildString {
                append(post.commentCount)
                append(" Comments")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]
        holder.bind(post)
    }


    override fun getItemCount(): Int {
        return posts.size
    }
}
