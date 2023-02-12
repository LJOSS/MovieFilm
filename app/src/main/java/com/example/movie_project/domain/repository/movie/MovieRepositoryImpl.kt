package com.example.movie_project.domain.repository.movie

import com.example.data.repository.language.LanguageRepository
import com.example.data.repository.movie.MovieRemoteRepository
import com.example.movie_project.domain.entity.MovieInfo
import com.example.movie_project.domain.entity.MoviePagedInfo
import com.example.movie_project.domain.entity.toMovieInfo
import com.example.movie_project.domain.entity.toMoviePagedInfo

class MovieRepositoryImpl(
    private val movieRemoteRepository: MovieRemoteRepository,
    private val languageRepository: LanguageRepository,
) : MovieRepository {

    override suspend fun getMovieList(page: Int): MoviePagedInfo {
        return movieRemoteRepository.getMovieList(page, languageRepository.getCurrentLanguage()).toMoviePagedInfo()
    }

    override suspend fun getMovieInfo(movieId: Long): MovieInfo {
        return movieRemoteRepository.getMovieInfo(movieId, languageRepository.getCurrentLanguage()).toMovieInfo()
    }
}