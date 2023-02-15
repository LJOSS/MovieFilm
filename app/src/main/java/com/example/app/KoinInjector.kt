package com.example.app

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
import com.example.presentation.presentation.movieDetail.MovieDetailViewModel
import com.example.presentation.presentation.movieList.MovieListViewModel
import com.example.presentation.usecase.GetMovieInfoUseCase
import com.example.presentation.usecase.GetMovieListUseCase
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

object KoinInjector {

    fun inject(app: App) {
        startKoin {
            modules(
                dataModule,
                useCaseModule,
                repositoryModule,
                viewModelModule,
                mapperModule
            )
        }.androidContext(app)
    }
}

val viewModelModule = module {
    viewModel {
        MovieListViewModel(getMovieListUseCase = get())
    }
    viewModel { parameters ->
        MovieDetailViewModel(movieId = parameters.get(), getMovieInfoUseCase = get())
    }
}

val useCaseModule = module {
    factory {
        GetMovieInfoUseCase(
            movieRepository = get(),
            getConfigurationRepository = get(),
            ratingMapper = get(),
            dateMapper = get(),
            budgetMapper = get()
        )
    }
    factory {
        GetMovieListUseCase(
            movieRepository = get(),
            getConfigurationRepository = get(),
            getGenreRepository = get(),
            ratingMapper = get(),
            dateMapper = get()
        )
    }
}

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
