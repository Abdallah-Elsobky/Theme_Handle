package com.example.theme_handle.dummy_data

import androidx.annotation.DrawableRes

data class Story(
    val id: String,
    val userName: String,
    @DrawableRes val avatarResId: Int,
    val isViewed: Boolean = false
)