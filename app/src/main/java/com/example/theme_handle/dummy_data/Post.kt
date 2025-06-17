package com.example.theme_handle.dummy_data

import androidx.annotation.DrawableRes

data class Post(
    val id: String,
    val userId: String,
    val userName: String,
    @DrawableRes val userAvatarResId: Int,
    val postTime: String,
    @DrawableRes val postImageResId: Int,
    val postDescription: String,
    val likeCount: Int,
    val commentCount: Int,
    val isLiked: Boolean = false
)