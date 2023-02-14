package com.example.movie_project

import com.example.di.mapperModule
import com.example.di.networkModule
import com.example.di.repositoryModule
import com.example.movie_project.presentation.movie_detail.MovieDetailViewModel
import com.example.movie_project.presentation.movie_list.MovieListViewModel
import com.example.movie_project.usecase.GetMovieInfoUseCase
import com.example.movie_project.usecase.GetMovieListUseCase
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

object KoinInjector {

    fun inject(app: App) {
        startKoin {
            modules(
                networkModule, useCaseModule, repositoryModule, viewModelModule, mapperModule
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
