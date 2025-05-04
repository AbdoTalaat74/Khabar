package com.loc.newsapp.presentation.onboarding

import androidx.annotation.DrawableRes
import com.loc.newsapp.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        title = "Breaking News",
        description = "Stay updated with the latest breaking news from around the globe. From politics to sports, we've got you covered.",
        image = R.drawable.onboarding_1
    ),
    Page(
        title = "Explore Categories",
        description = "Browse through various news categories and discover stories that spark your interest. Stay informed across all topics.",
        image = R.drawable.onboarding_2
    ),
    Page(
        title = "Stay Connected",
        description = "Get real-time alerts and never miss important updates. Your gateway to the world’s events, delivered instantly.",
        image = R.drawable.onboarding_3
    )
)