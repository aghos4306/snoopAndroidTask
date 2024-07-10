package com.aghogho.snoopandroidtask.presentation.cat_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aghogho.snoopandroidtask.presentation.cat_list.components.CatListItem
import com.aghogho.snoopandroidtask.presentation.screen.Screen

@Composable
fun CatListScreen(
    navController: NavController,
    catListViewModel: CatListViewModel = hiltViewModel()
) {
    val catState = catListViewModel.catState.value
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(catState.catData) { catData ->
                CatListItem(
                    catItems = catData,
                    onItemClick = {
                        navController.navigate(Screen.CatDetailScreen.route + "/${it}")
                    }
                )
                Divider(modifier = Modifier.padding(horizontal = 16.dp))
            }
        }
        if (catState.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
        if (catState.error.isNotBlank()) {
            Text(
                text = catState.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}
