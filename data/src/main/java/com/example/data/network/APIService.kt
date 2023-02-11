package com.example.data.network

import com.example.data.network.dto.ConfigurationResponseDTO
import com.example.data.network.dto.MovieDetailsResponseDTO
import com.example.data.network.dto.PagedResponseDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIService {

    @GET("/3/discover/movie")
    suspend fun getMovieList(
        @Query("page") page: Int,
        @Query("language") language: String
    ): PagedResponseDTO

    @GET("/3/movie/{movieId}")
    suspend fun getMovieInfo(
        @Path("movieId") movieId: Long,
        @Query("language") language: String
    ): MovieDetailsResponseDTO

    @GET("/3/configuration")
    suspend fun getConfiguration(): ConfigurationResponseDTO
}