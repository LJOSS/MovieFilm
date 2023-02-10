package com.example.movie_project.domain.entity

import com.example.data.network.dto.MovieResponseDTO
import com.example.data.network.dto.PagedResponseDTO
import java.time.LocalDate

data class MoviePagedInfo(
    val page: Int?,
    val results: List<Movie>
)

data class Movie(
    val isAdult: Boolean?,
    val backDropPath: String?,
    val genreIds: List<Long>?,
    val id: Long,
    val originalLanguage: String?,
    val originalTitle: String?,
    val popularity: Float?,
    val overview: String?,
    val posterPath: String?,
    val releaseDate: LocalDate?,
    val title: String?,
    val isVideo: Boolean?,
    val voteAverage: Float?,
    val voteCount: Int?,
)

fun PagedResponseDTO.toMoviePagedInfo() = MoviePagedInfo(
    page, results?.map { it.toMovie() } ?: listOf()
)

fun MovieResponseDTO.toMovie() = Movie(
    isAdult,
    backDropPath,
    genreIds,
    id,
    originalLanguage,
    originalTitle,
    popularity,
    overview,
    posterPath,
    releaseDate,
    title,
    isVideo,
    voteAverage,
    voteCount
)