package com.aghogho.snoopandroidtask.presentation.cat_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
@Composable
fun CatDetailScreen(
    id: String,
    catDetailViewModel: CatDetailViewModel = hiltViewModel()
) {
    val catDetailState = catDetailViewModel.catDetailState.value

    LaunchedEffect(id) {
        catDetailViewModel.getCatDetailInfo(id)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        if (catDetailState.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else if (catDetailState.catDetailData != null) {
            val catData = catDetailState.catDetailData
            Column {
                Text(
                    text = catData.name,
                    style = MaterialTheme.typography.headlineMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Image(
                    modifier = Modifier
                        .size(200.dp)
                        .align(Alignment.CenterHorizontally),
                    painter = rememberAsyncImagePainter(model = catData.imageUrl),
                    contentDescription = catData.name
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Cat Origin: ${catData.origin}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Description: ${catData.description}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Temperament: ${catData.temperament}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Life Span: ${catData.lifeSpan}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "More info: ${catData.wikipediaUrl}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        } else if (catDetailState.error.isNotBlank()) {
            Text(
                text = catDetailState.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}


















