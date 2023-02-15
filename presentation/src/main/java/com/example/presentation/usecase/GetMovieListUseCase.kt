package com.example.presentation.usecase

import com.example.domain.domain.mapper.DateMapper
import com.example.domain.domain.mapper.RatingMapper
import com.example.domain.domain.repository.confuguration.ConfigurationRepository
import com.example.domain.domain.repository.genre.GenreRepository
import com.example.domain.domain.repository.movie.MovieRepository
import com.example.presentation.presentation.entity.MoviePagedInfoUI
import com.example.presentation.presentation.entity.MovieUI
import com.example.presentation.presentation.entity.RatingColoredUI
import com.example.presentation.presentation.entity.RatingUI
import com.example.presentation.utils.UseCase

class GetMovieListUseCase(
    private val movieRepository: MovieRepository,
    private val getConfigurationRepository: ConfigurationRepository,
    private val getGenreRepository: GenreRepository,
    private val ratingMapper: RatingMapper,
    private val dateMapper: DateMapper
) : UseCase<GetMovieListUseCase.MovieParams, MoviePagedInfoUI>() {

    override suspend fun executeOnBackground(params: MovieParams): MoviePagedInfoUI {
        val moviePagedInfo = movieRepository.getMovieList(params.page)

        return MoviePagedInfoUI(
            moviePagedInfo.page,
            moviePagedInfo.results.map {
                val ratingUI =
                    RatingColoredUI.getRatingUIById(ratingMapper.getRatingColor(it.rating))

                MovieUI(
                    id = it.id,
                    posterUrl = "${getConfigurationRepository.getPosterImageBaseUrl()}${it.posterUrl}",
                    rating = RatingUI(it.rating, ratingUI.ratingColor),
                    voteCount = it.voteCount,
                    title = it.originalTitle,
                    originalTitle = it.title,
                    date = dateMapper.mapToYYYYMM(it.date),
                    genres = getGenreRepository.getListOfGenreById(it.genres)
                        .joinToString { "$it" }
                )
            }
        )
    }

    data class MovieParams(
        val page: Int
    )
}
