package com.example.domain.domain.entity

import java.time.LocalDate

data class MovieInfo(
    val isAdult: Boolean,
    val backDropPath: String,
    val budget: Long,
    val genres: List<GenreInfo>,
    val homepage: String,
    val id: Long,
    val originalTitle: String,
    val overview: String,
    val posterPath: String,
    val releaseDate: LocalDate,
    val status: String,
    val tagline: String,
    val title: String,
    val isVideo: Boolean,
    val voteAverage: Float,
    val voteCount: Int
)

data class GenreInfo(
    val id: Long,
    val name: String
)
