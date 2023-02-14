package com.example.di

import com.example.data.dataModule
import com.example.domain.domain.mapper.BudgetMapper
import com.example.domain.domain.mapper.DateMapper
import com.example.domain.domain.mapper.RatingMapper
import com.example.domain.domain.repository.confuguration.ConfigurationRepository
import com.example.domain.domain.repository.confuguration.ConfigurationRepositoryImpl
import com.example.domain.domain.repository.genre.GenreRepository
import com.example.domain.domain.repository.genre.GenreRepositoryImpl
import com.example.domain.domain.repository.movie.MovieRepository
import com.example.domain.domain.repository.movie.MovieRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory<MovieRepository> { MovieRepositoryImpl(movieRemoteRepository = get()) }
    single<ConfigurationRepository> { ConfigurationRepositoryImpl(remoteConfigurationRepository = get()) }
    single<GenreRepository> { GenreRepositoryImpl(genreRemoteRepository = get()) }
}
val mapperModule = module {
    factory { RatingMapper() }
    factory { DateMapper() }
    factory { BudgetMapper() }
}

val networkModule = dataModule
