package com.example.data

import com.example.data.network.APIService
import com.example.data.network.adapter.LocalDateJsonAdapter
import com.example.data.repository.configuration.RemoteConfigurationRepository
import com.example.data.repository.configuration.RemoteConfigurationRepositoryImpl
import com.example.data.repository.genre.GenreRemoteRepository
import com.example.data.repository.genre.GenreRemoteRepositoryImpl
import com.example.data.repository.language.LanguageRepository
import com.example.data.repository.language.LanguageRepositoryImpl
import com.example.data.repository.movie.MovieRemoteRepository
import com.example.data.repository.movie.MovieRemoteRepositoryImpl
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule = module {

    factory {
        OkHttpClient.Builder()
            .addInterceptor { chain ->
                chain.proceed(
                    chain.request().let { request ->
                        request.newBuilder().apply {
                            url(
                                request.url().newBuilder().addQueryParameter(
                                    "api_key",
                                    BuildConfig.API_KEY
                                ).build()
                            )
                        }.build()
                    }
                )
            }
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    setLevel(
                        if (BuildConfig.DEBUG) {
                            HttpLoggingInterceptor.Level.BODY
                        } else {
                            HttpLoggingInterceptor.Level.NONE
                        }
                    )
                }
            )
            .build()
    }

    factory {
        MoshiConverterFactory.create(
            Moshi.Builder()
                .add(LocalDateJsonAdapter())
                .add(KotlinJsonAdapterFactory())
                .build()
        )
    }

    factory {
        Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .client(get())
            .addConverterFactory(get<MoshiConverterFactory>())
            .build()
    }

    factory { get<Retrofit>().create(APIService::class.java) }

    factory<MovieRemoteRepository> { MovieRemoteRepositoryImpl(apiService = get()) }

    factory<LanguageRepository> { LanguageRepositoryImpl() }

    single<RemoteConfigurationRepository> { RemoteConfigurationRepositoryImpl(apiService = get()) }

    single<GenreRemoteRepository> {
        GenreRemoteRepositoryImpl(
            apiService = get(),
            languageRepository = get()
        )
    }
}