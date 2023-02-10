package com.example.data.repository

import com.example.data.network.dto.MovieDetailsResponseDTO
import com.example.data.network.dto.PagedResponseDTO

interface MovieRepository {

    suspend fun getMovieList(
        page: Int,
        language: String = "en"
    ): PagedResponseDTO

    suspend fun getMovieInfo(
        movieId: Long,
        language: String = "en"
    ): MovieDetailsResponseDTO

}