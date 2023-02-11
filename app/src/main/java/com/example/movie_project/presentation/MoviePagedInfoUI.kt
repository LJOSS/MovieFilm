package com.example.movie_project.presentation

import androidx.annotation.ColorInt
import androidx.annotation.ColorRes

data class MoviePagedInfoUI(
    val page: Int = 0,
    val results: List<MovieUI> = emptyList()
)

data class MovieUI(
    val id: Long,
    val posterUrl: String,
    val rating: RatingUI,
    val voteCount: Int,
    val title: String,
    val originalTitle: String,
    val year: String,
    val genres: String
)

data class RatingUI(
    val value: Float,
    @ColorRes val ratingColor: Int,
)