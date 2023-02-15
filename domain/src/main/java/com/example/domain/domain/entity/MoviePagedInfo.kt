package com.example.domain.domain.entity

import java.time.LocalDate

data class MoviePagedInfo(
    val page: Int = 0,
    val results: List<Movie> = emptyList()
)

data class Movie(
    val id: Long,
    val posterUrl: String,
    val rating: Float,
    val voteCount: Int,
    val title: String,
    val originalTitle: String,
    val date: LocalDate,
    val genres: List<Long>
)
