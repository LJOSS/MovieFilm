package com.example.data.network.entity

import com.squareup.moshi.Json
import java.time.LocalDate

data class MovieDetailsResponse(
    @Json(name = "adult")
    val isAdult: Boolean?,
    @Json(name = "backdrop_path")
    val backDropPath: String?,
    @Json(name = "budget")
    val budget: Long,
    @Json(name = "genres")
    val genres: List<GenreResponse>?,
    @Json(name = "homepage")
    val homepage: String?,
    @Json(name = "id")
    val id: Long,
    @Json(name = "original_title")
    val originalTitle: String?,
    @Json(name = "overview")
    val overview: String?,
    @Json(name = "poster_path")
    val posterPath: String?,
    @Json(name = "release_date")
    val releaseDate: LocalDate?,
    @Json(name = "status")
    val status: String?,
    @Json(name = "tagline")
    val tagline: String?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "video")
    val isVideo: Boolean?,
    @Json(name = "vote_average")
    val voteAverage: Float?,
    @Json(name = "vote_count")
    val voteCount: Int?
)

data class GenreListResponse(
    @Json(name = "genres")
    val genres: List<GenreResponse>
)

data class GenreResponse(
    @Json(name = "id")
    val id: Long,
    @Json(name = "name")
    val name: String
)
