package com.loc.newsapp.domain.uscases.news

import com.loc.newsapp.domain.repository.NewsRepository

class SelectArticle(
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke(url: String) = newsRepository.getArticle(url)
}