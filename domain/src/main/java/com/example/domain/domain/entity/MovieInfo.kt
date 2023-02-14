package com.example.domain.domain.entity

import com.example.data.network.entity.MovieDetailsResponse
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
    val voteCount: Int,
)

data class GenreInfo(
    val id: Long,
    val name: String
)

fun MovieDetailsResponse.toMovieInfo() = MovieInfo(
    isAdult ?: false,
    backDropPath.orEmpty(),
    budget,
    genres?.map { GenreInfo(it.id, it.name) } ?: emptyList(),
    homepage.orEmpty(),
    id,
    originalTitle.orEmpty(),
    overview.orEmpty(),
    posterPath.orEmpty(),
    releaseDate ?: LocalDate.now(),
    status.orEmpty(),
    tagline.orEmpty(),
    title.orEmpty(),
    isVideo ?: false,
    voteAverage ?: 0.0f,
    voteCount ?: 0,
)