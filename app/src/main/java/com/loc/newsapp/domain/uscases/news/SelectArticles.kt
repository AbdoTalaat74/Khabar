package com.loc.newsapp.domain.uscases.news

import com.loc.newsapp.data.local.NewsDao

class SelectArticles(
    private val newsDao: NewsDao
) {
    operator fun invoke() = newsDao.getArticles()

}