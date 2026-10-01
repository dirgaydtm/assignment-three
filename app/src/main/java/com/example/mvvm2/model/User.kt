package com.example.mvvm2.model

import androidx.annotation.DrawableRes
import com.example.mvvm2.R

data class User(
    val id: Int = 0,
    val name: String = "",
    val username: String = "",
    val email: String = "",
    @DrawableRes val imageResId: Int = R.drawable.profile_picture
)
