package com.nelson.ramirez.videos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nelson.ramirez.videos.home.data.ContentItem
import com.nelson.ramirez.videos.home.data.ContentItemType
import com.nelson.ramirez.videos.home.data.Shelf
import com.nelson.ramirez.videos.home.data.HomePageDataSource
import com.nelson.ramirez.videos.ui.components.Episode
import com.nelson.ramirez.videos.ui.components.Live
import com.nelson.ramirez.videos.ui.components.Show
import com.nelson.ramirez.videos.ui.theme.VideosTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VideosTheme {
                //TODO this would be exposed and injected via a viewmodel
                HomePageDataSource().homePage?.let {
                    HomeScreenContent(
                        it.shelves
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreenContent(shelfList: List<Shelf>) {
    val shelves = rememberPagerState(pageCount = { shelfList.size })
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF0089a8), // Start color
                        Color(0xFF500053)  // End color

                    )
                )
            )
            .padding(top = 48.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
    ) {
        VerticalPager(state = shelves, pageSize = PageSize.Fixed(300.dp)) { shelfIndex: Int ->
            Text(
                style = MaterialTheme.typography.titleLarge,
                text = shelfList[shelfIndex].title,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()

            )
            Spacer(modifier = Modifier.height(16.dp))
            val content = rememberPagerState {
                shelfList[shelfIndex].items.size
            }
            HorizontalPager(
                state = content,
                pageSize = PageSize.Fixed(150.dp),
                pageSpacing = 16.dp,
                verticalAlignment = androidx.compose.ui.Alignment.Top
            ) { itemIndex: Int ->
                ContentItem(shelfList[shelfIndex].items[itemIndex])
            }

        }
    }
}


@Composable
fun ContentItem(contentItem: ContentItem) {
    when (contentItem.type) {
        ContentItemType.Episode -> Episode(contentItem as ContentItem.Episode)
        ContentItemType.Live -> Live(contentItem as ContentItem.Live)
        ContentItemType.Show -> Show(contentItem as ContentItem.Show)
    }

}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    VideosTheme {
        HomeScreenContent(
            listOf(
                Shelf(
                    "Just In",
                    listOf(
                        ContentItem.Episode(
                            "EndGame",
                            "Season 1 Episode 1",
                            "https://img.nbc.com/sites/nbcunbc/files/images/2022/1/28/EndGame_S1-KeyArt-Logo-Vertical-852x1136.jpg",
                            "New"
                        )
                    )
                )
            )
        )
    }
}

