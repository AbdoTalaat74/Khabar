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
        title = "Stay Informed with Real-Time News",
        description = "Get the latest updates from around the world delivered to your fingertips. Stay ahead with breaking news, top headlines, and stories tailored to your interests.",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Customize Your News Experience",
        description = "Choose the topics that matter most to you. Whether it’s politics, technology, sports, or entertainment, we’ll deliver the news you care about.",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "Engage with Insightful Content",
        description = "Dive deeper into the news with in-depth articles, expert opinions, and engaging multimedia content. Stay informed and inspired with every read.",
        image = R.drawable.onboarding3
    ),


    )