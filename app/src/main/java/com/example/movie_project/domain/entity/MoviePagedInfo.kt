package com.example.movie_project.domain.entity

import com.example.data.network.dto.MovieResponseDTO
import com.example.data.network.dto.PagedResponseDTO
import java.time.LocalDate
import java.time.format.DateTimeFormatter

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
    val year: String,
    val genres: List<Long>
)

fun PagedResponseDTO.toMoviePagedInfo() = MoviePagedInfo(
    page ?: 0, results?.map { it.toMovie() } ?: listOf()
)

fun MovieResponseDTO.toMovie() = Movie(
    id = id,
    rating = voteAverage ?: 0f,
    posterUrl = posterPath ?: "",
    title = title ?: originalTitle ?: "",
    originalTitle = originalTitle ?: "",
    voteCount = voteCount ?: 0,
    year = releaseDate ?: "",
    genres = genreIds ?: listOf()
)