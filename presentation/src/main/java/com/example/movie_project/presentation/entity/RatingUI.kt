package com.example.movie_project.presentation.entity

import androidx.annotation.ColorRes
import com.example.movie_project.R

data class RatingUI(
    val value: Float = 0.0f,
    @ColorRes val ratingColor: Int = R.color.black,
)
