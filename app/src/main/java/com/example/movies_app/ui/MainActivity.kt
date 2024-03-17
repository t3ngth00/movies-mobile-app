package com.example.movies_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movies_app.ui.MainList
import com.example.movies_app.ui.MovieDetails
import com.example.movies_app.ui.theme.MoviesappTheme
import com.example.movies_app.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    val mainViewModel by viewModels<MainViewModel>()

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MoviesappTheme {
                NavHost(navController = navController, startDestination = "trendingMovieList") {
                    composable("trendingMovieList") {
                        // A surface container using the 'background' color from the theme
                        Surface(color = MaterialTheme.colorScheme.background) {
                            MainList(navController = navController, mainViewModel = mainViewModel)
                        }
                    }
                    composable("movieDetails") {
                        MovieDetails(mainViewModel.clickedItem)
                    }
                }
            }
        }
    }
}


