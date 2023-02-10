package com.example.movie_project.domain.usecase

import com.example.common.UseCase
import com.example.movie_project.domain.entity.MoviePagedInfo
import com.example.movie_project.domain.repository.MovieRepository

class GetMovieListUseCase(
    private val movieRepository: MovieRepository
) : UseCase<GetMovieListUseCase.MovieParams, MoviePagedInfo>() {

    override suspend fun executeOnBackground(params: MovieParams): MoviePagedInfo {
        return movieRepository.getMovieList(params.page)
    }

    data class MovieParams(
        val page: Int
    )
}