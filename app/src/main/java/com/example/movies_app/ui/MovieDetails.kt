package com.example.movies_app.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movies_app.model.Constants
import com.example.movies_app.model.MovieItem
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun MovieDetails(movieItem: MovieItem){
    Column() {
        MovieDetailsBanner(movieItem = movieItem)
        MovieDetailsText(movieItem = movieItem)
    }
}

@Composable
fun MovieDetailsBanner(movieItem: MovieItem){
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(300.dp)) {
        Image(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),painter = rememberCoilPainter(request = Constants.BASE_IMAGE_URL+movieItem.backdrop_path) , contentDescription = "")
    }
}
@Composable
fun MovieDetailsText(movieItem: MovieItem){
    Column(modifier = Modifier.padding(10.dp)) {
        movieItem.title?.let {
            Text(text = it, fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Normal,
                fontSize = 24.sp)
        }
        Text(text = movieItem.overview, Modifier.padding(top=10.dp),fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp)
    }

}