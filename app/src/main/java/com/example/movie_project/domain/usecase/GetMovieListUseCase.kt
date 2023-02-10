package com.example.movie_project.domain.usecase

import com.example.common.UseCase
import com.example.movie_project.domain.repository.MovieRemoteRepository

class GetMovieListUseCase(
    private val movieRepository: MovieRemoteRepository
) : UseCase<GetMovieListUseCase.MovieParams, Int>() {

    override suspend fun executeOnBackground(params: MovieParams): Int {
        val q = movieRepository.getMovieList(params.page)
        return q.results.size
    }

    data class MovieParams(
        val page: Int
    )
}