package com.loc.newsapp.presentation.details

import com.loc.newsapp.domain.model.Article


sealed class DetailsEvent{
    data class UpsertDeleteArticle(val article: Article): DetailsEvent()

    data object RemoveSideEffect: DetailsEvent()
}
