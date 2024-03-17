package com.example.movies_app.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.example.movies_app.R
import com.example.movies_app.model.MovieItem
import com.example.movies_app.viewmodel.MainViewModel

@ExperimentalFoundationApi
@Composable
fun MainList(navController: NavController,
             mainViewModel: MainViewModel
){
    MovieList(navController = navController,movieList = mainViewModel.trendingMovies,
        onItemClicked = mainViewModel::itemClicked)
}

@ExperimentalFoundationApi
@Composable
fun MovieList(
    navController: NavController,
    movieList:List<MovieItem>,
    onItemClicked:(item: MovieItem) ->Unit
){
    var listState = rememberLazyListState()
    val Red = Color(red=35,green = 61,blue = 83)

    LazyColumn(state = listState) {
        stickyHeader {
            MainHeader()
        }
        itemsIndexed(movieList){index, item ->
            ListViewItem(navController = navController,movieItem = item,onItemClicked)
        }
    }
}


@Composable
fun MainHeader(){
    Surface(
        Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Text(
            text = stringResource(R.string.popular_films),
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center
        )
    }
}