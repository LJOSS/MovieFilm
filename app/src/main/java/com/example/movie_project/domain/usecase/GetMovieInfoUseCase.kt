package com.example.movie_project.domain.usecase

import com.example.common.UseCase
import com.example.movie_project.domain.repository.MovieRepository

class GetMovieInfoUseCase(
    private val movieRepository: MovieRepository
) : UseCase<GetMovieInfoUseCase.MovieParams, Int>() {

    override suspend fun executeOnBackground(params: MovieParams): Int {
        movieRepository.getMovieInfo(params.movieId)
        return 2
    }

    data class MovieParams(
        val movieId: Long
    )
}