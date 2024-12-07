package com.loc.newsapp.presentation.details


sealed class DetailsEvent{
    data object SaveArticle: DetailsEvent()
}
