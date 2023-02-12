package com.example.movie_project.domain.usecase

import com.example.common.UseCase
import com.example.movie_project.domain.mapper.RatingMapper
import com.example.movie_project.domain.repository.confuguration.ConfigurationRepository
import com.example.movie_project.domain.repository.genre.GenreRepository
import com.example.movie_project.domain.repository.movie.MovieRepository
import com.example.movie_project.presentation.entity.MoviePagedInfoUI
import com.example.movie_project.presentation.entity.MovieUI
import com.example.movie_project.presentation.entity.RatingUI

class GetMovieListUseCase(
    private val movieRepository: MovieRepository,
    private val getConfigurationRepository: ConfigurationRepository,
    private val getGenreRepository: GenreRepository,
    private val ratingMapper: RatingMapper,
) : UseCase<GetMovieListUseCase.MovieParams, MoviePagedInfoUI>() {

    override suspend fun executeOnBackground(params: MovieParams): MoviePagedInfoUI {
        val moviePagedInfo = movieRepository.getMovieList(params.page)
        return MoviePagedInfoUI(
            moviePagedInfo.page,
            moviePagedInfo.results.map {
                MovieUI(
                    id = it.id,
                    posterUrl = "${getConfigurationRepository.getPosterImageBaseUrl()}${it.posterUrl}",
                    rating = RatingUI(it.rating, ratingMapper.getRatingColor(it.rating)),
                    voteCount = it.voteCount,
                    title = it.originalTitle,
                    originalTitle = it.title,
                    date = it.date,
                    genres = getGenreRepository.getListOfGenreById(it.genres)
                        .joinToString { "$it" },
                )
            }
        )
    }

    data class MovieParams(
        val page: Int
    )
}