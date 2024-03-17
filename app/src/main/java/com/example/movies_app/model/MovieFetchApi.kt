package com.example.movies_app.model

import retrofit2.http.GET

// You can get your API key from https://www.themoviedb.org
const val API_KEY = "Your API key"

interface MovieFetchApi {

    @GET("trending/all/day?api_key=$API_KEY")
    suspend fun fetchTrendingMovieList() : MovieResponse
}