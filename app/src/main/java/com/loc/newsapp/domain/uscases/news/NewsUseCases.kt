package com.loc.newsapp.domain.uscases.news

data class NewsUseCases(
    val getNews: GetNewsUseCase,
    val searchNews: SearchNewsUseCase,
    val upsertArticle: UpsertArticle,
    val deleteArticle: DeleteArticle,
    val selectArticles: SelectArticles
)
