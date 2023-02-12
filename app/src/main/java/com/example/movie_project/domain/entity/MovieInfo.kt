package com.example.movie_project.domain.entity

import com.example.data.network.dto.GenreResponseDTO
import com.example.data.network.dto.MovieDetailsResponseDTO
import java.time.LocalDate

data class MovieInfo(
    val isAdult: Boolean,
    val backDropPath: String,
    val budget: Long,
    val genres: List<GenreResponseDTO>,
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
    val voteAverage: Float,
    val voteCount: Int,
)


fun MovieDetailsResponseDTO.toMovieInfo() = MovieInfo(
    isAdult ?: false,
    backDropPath.orEmpty(),
    budget,
    genres,
    homepage.orEmpty(),
    id,
    originalTitle.orEmpty(),
    overview.orEmpty(),
    posterPath.orEmpty(),
    releaseDate.orEmpty(),
    status.orEmpty(),
    tagline.orEmpty(),
    title.orEmpty(),
    isVideo ?: false,
    voteAverage ?: 0.0f,
    voteCount ?: 0,
)