package com.example.domain.domain.entity

import com.example.data.network.entity.MovieResponse
import com.example.data.network.entity.PagedResponse
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

fun PagedResponse.toMoviePagedInfo() = MoviePagedInfo(
    page ?: 0,
    results?.map { it.toMovie() } ?: listOf()
)

fun MovieResponse.toMovie() = Movie(
    id = id,
    rating = voteAverage ?: 0f,
    posterUrl = posterPath ?: "",
    title = title ?: originalTitle ?: "",
    originalTitle = originalTitle ?: "",
    voteCount = voteCount ?: 0,
    date = releaseDate ?: LocalDate.now(),
    genres = genreIds ?: listOf()
)
