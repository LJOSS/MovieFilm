package com.example.movie_project.domain.entity

import com.example.data.network.dto.GenreResponseDTO
import com.example.data.network.dto.MovieDetailsResponseDTO
import java.time.LocalDate

data class MovieInfo(
    val isAdult: Boolean?,
    val backDropPath: String?,
    val budget: Long,
    val genres: List<GenreResponseDTO>,
    val homepage: String?,
    val id: Long,
    val originalTitle: String?,
    val overview: String?,
    val posterPath: String?,
    val releaseDate: LocalDate?,
    val status: String?,
    val tagline: String?,
    val title: String?,
    val isVideo: Boolean?,
    val voteAverage: Float?,
    val voteCount: Int?,
)

data class GenreResponseDTO(
    val id: Long,
    val name: String
)

fun MovieDetailsResponseDTO.toMovieInfo() = MovieInfo(
    isAdult,
    backDropPath,
    budget,
    genres,
    homepage,
    id,
    originalTitle,
    overview,
    posterPath,
    releaseDate,
    status,
    tagline,
    title,
    isVideo,
    voteAverage,
    voteCount
)