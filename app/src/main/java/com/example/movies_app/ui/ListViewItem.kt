package com.example.movies_app.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movies_app.model.Constants
import com.example.movies_app.model.MovieItem
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun ListViewItem(
    navController: NavController,
    movieItem: MovieItem,
    onItemClicked: (item: MovieItem) -> Unit
) {
    ListViewItem(movieItem = movieItem, modifier = Modifier
        .padding(8.dp)
        .clickable {
            onItemClicked(movieItem)
            navController.navigate("movieDetails")
        })
}

@Composable
fun ListViewItem(movieItem: MovieItem, modifier: Modifier) {
    Card(modifier = modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            MovieImageBanner(imagePath = movieItem.backdrop_path)
            MovieMetadataItem(movieItem = movieItem)
        }
    }

}


@Composable
fun MovieMetadataItem(movieItem: MovieItem){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(start = 10.dp)) {
        movieItem?.title?.let {
            Text(
                text = it
            )
            Text(
                text = movieItem.vote_average,
                style = MaterialTheme.typography.bodyLarge
            )
        }

    }
}

@Composable
fun MovieImageBanner(imagePath: String) {

    Image(
        modifier = Modifier
            .width(180.dp)
            .height(100.dp), painter = rememberCoilPainter(
            request = Constants.BASE_IMAGE_URL + imagePath
        ),
        contentDescription = ""
    )
}