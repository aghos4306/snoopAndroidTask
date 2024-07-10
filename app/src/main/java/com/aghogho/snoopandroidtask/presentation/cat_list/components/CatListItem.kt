package com.aghogho.snoopandroidtask.presentation.cat_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.aghogho.snoopandroidtask.domain.model.CatModel

@Composable
fun CatListItem(
    catItems: CatModel,
    //onItemClick: (CatModel) -> Unit
    onItemClick: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { catItems.referenceImageId?.let { onItemClick(it) } }
            .padding(20.dp)
    ) {
        catItems.image?.url?.let { imageUrl ->
            Image(
                painter = rememberAsyncImagePainter(model = imageUrl),
                contentDescription = catItems.name,
                modifier = Modifier.size(72.dp)
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = catItems.name, style = MaterialTheme.typography.headlineSmall)
            Text(text = catItems.origin, style = MaterialTheme.typography.bodyMedium)
        }
    }
}
