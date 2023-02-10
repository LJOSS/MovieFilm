package com.example.movie_project

import com.example.data.network.networkModule
import com.example.movie_project.domain.repository.MovieRepository
import com.example.movie_project.domain.repository.MovieRepositoryImpl
import com.example.movie_project.domain.usecase.GetMovieInfoUseCase
import com.example.movie_project.domain.usecase.GetMovieListUseCase
import com.example.movie_project.presentation.movie_detail.MovieDetailViewModel
import com.example.movie_project.presentation.movie_list.MovieListViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

object KoinInjector {

    fun inject(app: App) {
        startKoin {
            modules(
                networkModule, useCaseModule, repositoryModule, viewModelModule,
            )
        }.androidContext(app)
    }
}

val viewModelModule = module {
    viewModel {
        MovieListViewModel(getMovieListUseCase = get())
    }
    viewModel {
        MovieDetailViewModel(getMovieInfoUseCase = get())
    }
}

val useCaseModule = module {
    factory {
        GetMovieInfoUseCase(get())
    }
    factory {
        GetMovieListUseCase(get())
    }
}

val repositoryModule = module {
    factory<MovieRepository> { MovieRepositoryImpl(get()) }
}