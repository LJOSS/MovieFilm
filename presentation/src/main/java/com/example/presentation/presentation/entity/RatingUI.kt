package com.example.presentation.presentation.entity

import androidx.annotation.ColorRes
import com.example.presentation.R

data class RatingUI(
    val value: Float = 0.0f,
    @ColorRes val ratingColor: Int = R.color.black,
)
