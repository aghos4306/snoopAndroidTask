package com.aghogho.snoopandroidtask.presentation.cat_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aghogho.snoopandroidtask.domain.model.CatModel
import com.aghogho.snoopandroidtask.util.widgets.CircularImage

@Composable
fun CatListItem(
    catItems: CatModel,
    onItemClick: (String) -> Unit,
    onFavouriteClicked: (CatModel) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { catItems.referenceImageId?.let { onItemClick(it) } }
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CircularImage(
            imageUrl = catItems.image?.url,
            contentDescription = catItems.name,
            size = 72.dp
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = catItems.name,
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            )
            Text(text = catItems.origin, style = MaterialTheme.typography.bodyMedium)
        }
        IconButton(
            onClick = { onFavouriteClicked(catItems) },
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            Icon(
                imageVector = if (catItems.isFavourited) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                contentDescription = "favorite"
            )
        }
    }
}
