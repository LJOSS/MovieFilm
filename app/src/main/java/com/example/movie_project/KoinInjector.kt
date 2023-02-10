package com.example.movie_project

import com.example.data.network.networkModule
import com.example.data.repository.MovieRepository
import com.example.data.repository.MovieRepositoryImpl
import com.example.movie_project.domain.repository.MovieRemoteRepository
import com.example.movie_project.domain.repository.MovieRemoteRepositoryImpl
import com.example.movie_project.domain.usecase.GetMovieInfoUseCase
import com.example.movie_project.domain.usecase.GetMovieListUseCase
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

object KoinInjector {

    fun inject(app: App) {
        startKoin {
            modules(
                networkModule, viewModelModule, useCaseModule, repositoryModule
            )
        }.androidContext(app)
    }
}

val viewModelModule = module {
    viewModel {
        MainViewModel(get(), get())
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
    factory<MovieRemoteRepository> { MovieRemoteRepositoryImpl(get()) }
}