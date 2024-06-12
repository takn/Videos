package com.nelson.ramirez.videos.home.data

import com.squareup.moshi.JsonClass

data class HomePage(
    val page: String,
    val shelves: List<Shelf>
)

data class Shelf(
    val title: String,
    val items: List<ContentItem>
)

sealed class ContentItem(val type: ContentItemType) {
    data class Episode(
        val title: String,
        val subtitle: String,
        val image: String,
        val labelBadge: String = ""
    ) : ContentItem(ContentItemType.Episode)

    data class Live(
        val title: String,
        val subtitle: String,
        val tagline: String,
        val image: String,
    ) : ContentItem(ContentItemType.Live)

    data class Show(
        val title: String,
        val image: String,
    ) : ContentItem(ContentItemType.Show)

}

enum class ContentItemType {
    Episode,
    Live,
    Show
}