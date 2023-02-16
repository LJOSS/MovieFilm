package com.example.data

import com.example.data.network.ApiService
import com.example.data.network.adapter.LocalDateJsonAdapter
import com.example.data.repository.ConfigurationRepository
import com.example.data.repository.GenreRemoteRepository
import com.example.data.repository.MovieRepository
import com.example.domain.domain.repository.confuguration.ConfigurationRepositoryApi
import com.example.domain.domain.repository.genre.GenreRepositoryApi
import com.example.domain.domain.repository.movie.MovieRepositoryApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val dataModule = module {

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

    factory { get<Retrofit>().create(ApiService::class.java) }

    factory<MovieRepositoryApi> { MovieRepository(apiService = get()) }

    single<ConfigurationRepositoryApi> { ConfigurationRepository(apiService = get()) }

    single<GenreRepositoryApi> { GenreRemoteRepository(apiService = get()) }
}
