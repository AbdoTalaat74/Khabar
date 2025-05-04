package com.loc.newsapp.domain.uscases.news

import com.loc.newsapp.domain.repository.NewsRepository

class SelectArticles(
    private val newsRepository: NewsRepository
) {
    operator fun invoke() = newsRepository.getArticles()

}