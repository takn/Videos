package com.nelson.ramirez.videos.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.nelson.ramirez.videos.home.data.ContentItem
import com.nelson.ramirez.videos.ui.theme.VideosTheme

@Composable
fun Episode(data: ContentItem.Episode) {
    Column {
        AsyncImage(
            model = data.image,
            contentDescription = "image"
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(data.title, style = MaterialTheme.typography.titleSmall, color = Color.White)
        Spacer(modifier = Modifier.height(8.dp))
        Text(data.subtitle, style = MaterialTheme.typography.labelSmall, color = Color.White)
        //TODO badge
    }
}

@Composable
fun Live(data: ContentItem.Live) {
    Column {
        AsyncImage(
            model = data.image,
            contentDescription = "image"
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(data.title, style = MaterialTheme.typography.titleSmall, color = Color.White)
        Spacer(modifier = Modifier.height(8.dp))
        Text(data.subtitle, style = MaterialTheme.typography.titleSmall, color = Color.White)
    }
}

@Composable
fun Show(data: ContentItem.Show) {
    Column {
        AsyncImage(
            model = data.image,
            contentDescription = "image"
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(data.title, style = MaterialTheme.typography.titleSmall, color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun ContentItemPreview() {
    VideosTheme {


        Episode(
            ContentItem.Episode(
                "EndGame",
                "Season 1 Episode 1",
                "https://img.nbc.com/sites/nbcunbc/files/images/2022/1/28/EndGame_S1-KeyArt-Logo-Vertical-852x1136.jpg",
                "New"
            )
        )
        Live(
            ContentItem.Live(
                "Title",
                "Subtitle",
                "Tagline",
                "https://img.nbc.com/sites/nbcunbc/files/images/2022/1/28/EndGame_S1-KeyArt-Logo-Vertical-852x1136.jpg"
            )
        )
        Show(
            ContentItem.Show(
                "Title",
                "https://img.nbc.com/sites/nbcunbc/files/images/2022/1/28/EndGame_S1-KeyArt-Logo-Vertical-852x1136.jpg"
            )
        )


    }
}