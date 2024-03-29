package com.example.movies_app.model

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object MovieApiClient {
    const val BASE_URL ="https://api.themoviedb.org/3/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
    val  service:MovieFetchApi by lazy {
        retrofit.build().
        create(MovieFetchApi::class.java)
    }
}