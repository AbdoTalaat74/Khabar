package com.loc.newsapp.domain.uscases.news

import androidx.paging.PagingData
import com.loc.newsapp.domain.model.Article
import com.loc.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SearchNewsUseCase(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(searchQuery:String,sources:List<String>): Flow<PagingData<Article>>{
        return newsRepository.searchNews(searchQuery,sources)
    }
}