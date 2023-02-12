package com.example.movie_project

import com.example.data.networkModule
import com.example.movie_project.domain.mapper.BudgetMapper
import com.example.movie_project.domain.mapper.DateMapper
import com.example.movie_project.domain.mapper.RatingMapper
import com.example.movie_project.domain.repository.confuguration.ConfigurationRepository
import com.example.movie_project.domain.repository.confuguration.ConfigurationRepositoryImpl
import com.example.movie_project.domain.repository.genre.GenreRepository
import com.example.movie_project.domain.repository.genre.GenreRepositoryImpl
import com.example.movie_project.domain.repository.movie.MovieRepository
import com.example.movie_project.domain.repository.movie.MovieRepositoryImpl
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
        GetMovieInfoUseCase(get(), get(), get(), get(), get())
    }
    factory {
        GetMovieListUseCase(get(), get(), get(), get())
    }
}

val repositoryModule = module {
    factory<MovieRepository> { MovieRepositoryImpl(get(), get()) }
    single<ConfigurationRepository> { ConfigurationRepositoryImpl(get()) }
    single<GenreRepository> { GenreRepositoryImpl(get()) }
}
val mapperModule = module {
    factory { RatingMapper() }
    factory { DateMapper() }
    factory { BudgetMapper() }
}