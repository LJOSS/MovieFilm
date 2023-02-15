package com.example.data.network.entity

import com.squareup.moshi.Json
import java.time.LocalDate

data class PagedResponse(
    @Json(name = "page")
    val page: Int?,
    @Json(name = "total_pages")
    val totalPages: Long?,
    @Json(name = "total_results")
    val totalItems: Long?,
    @Json(name = "results")
    val results: List<MovieResponse>?
)

data class MovieResponse(
    @Json(name = "adult")
    val isAdult: Boolean?,
    @Json(name = "backdrop_path")
    val backDropPath: String?,
    @Json(name = "genre_ids")
    val genreIds: List<Long>?,
    @Json(name = "id")
    val id: Long,
    @Json(name = "original_language")
    val originalLanguage: String?,
    @Json(name = "original_title")
    val originalTitle: String?,
    @Json(name = "popularity")
    val popularity: Float?,
    @Json(name = "overview")
    val overview: String?,
    @Json(name = "poster_path")
    val posterPath: String?,
    @Json(name = "release_date")
    val releaseDate: LocalDate?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "video")
    val isVideo: Boolean?,
    @Json(name = "vote_average")
    val voteAverage: Float?,
    @Json(name = "vote_count")
    val voteCount: Int?
)
