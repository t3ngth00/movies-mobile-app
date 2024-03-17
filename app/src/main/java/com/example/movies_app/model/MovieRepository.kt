package com.example.movies_app.model

import android.util.Log

class MovieRepository(val movieFetchApi: MovieFetchApi) {

    sealed class Result {
        object Loading : Result()
        data class Success(val movieList: List<MovieItem>) : Result()
        data class Failure(val throwable: Throwable) : Result()
    }

    suspend fun fetchTrendingMovies(): Result {
        return try {
            val movieList = movieFetchApi.fetchTrendingMovieList().results
            Log.d("MOVIELIST", "success " + movieList.size)
            Result.Success(movieList = movieList)
        } catch (exception: Exception) {
            Log.d("MOVIELIST", "failure ")
            Result.Failure(exception)
        }
    }
}