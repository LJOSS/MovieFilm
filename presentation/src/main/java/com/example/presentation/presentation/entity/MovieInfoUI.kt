package com.example.presentation.presentation.entity

data class MovieInfoUI(
    val isAdult: Boolean,
    val backDropPath: String,
    val budget: String,
    val genres: String,
    val homepage: String,
    val id: Long,
    val originalTitle: String,
    val overview: String,
    val posterPath: String,
    val releaseDate: String,
    val status: String,
    val tagline: String,
    val title: String,
    val isVideo: Boolean,
    val voteAverage: RatingUI,
    val voteCount: Int
)
