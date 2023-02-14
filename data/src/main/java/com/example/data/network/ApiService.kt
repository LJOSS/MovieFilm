package com.example.data.network

import com.example.data.network.entity.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface ApiService {

    @GET("/3/discover/movie")
    suspend fun getMovieList(
        @Query("page") page: Int,
        @Query("language") language: String
    ): PagedResponse

    @GET("/3/movie/{movieId}")
    suspend fun getMovieInfo(
        @Path("movieId") movieId: Long,
        @Query("language") language: String
    ): MovieDetailsResponse

    @GET("/3/configuration")
    suspend fun getConfiguration(): ConfigurationResponse

    @GET("/3/genre/movie/list")
    suspend fun loadGenres(
        @Query("language") language: String
    ): GenreListResponse

}