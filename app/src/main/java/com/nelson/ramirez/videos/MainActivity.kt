package com.nelson.ramirez.videos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nelson.ramirez.videos.ui.theme.VideosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VideosTheme {
                HomeScreenContent()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreenContent() {
    val shelves = rememberPagerState(pageCount = {
        5
    })
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
    ){
        VerticalPager(state = shelves, pageSize = PageSize.Fixed(300.dp)) {
            Text(
                text = "Shelf $it",
                color = Color.Black,
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .background(Color.White)
            )
            val content = rememberPagerState {
                6
            }
            HorizontalPager(state = content, pageSize= PageSize.Fixed(100.dp)) {contentIndex:Int ->
                Text("Content $it: $contentIndex", modifier = Modifier.fillMaxSize())
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    VideosTheme {
        HomeScreenContent()
    }
}