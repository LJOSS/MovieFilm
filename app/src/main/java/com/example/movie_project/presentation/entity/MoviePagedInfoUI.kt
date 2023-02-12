package com.example.movie_project.presentation.entity

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
    val date: String,
    val genres: String
)
