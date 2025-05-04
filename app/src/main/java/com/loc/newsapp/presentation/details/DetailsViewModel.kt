package com.loc.newsapp.presentation.details

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loc.newsapp.domain.model.Article
import com.loc.newsapp.domain.uscases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
) : ViewModel() {

    var sideEffect by mutableStateOf<String?>(null)
        private set

    private var _isArticleSaved = mutableStateOf(false)
    var isArticleSaved:State<Boolean> = _isArticleSaved

    fun onEvent(event: DetailsEvent) {
        when (event) {
            is DetailsEvent.UpsertDeleteArticle -> {
                viewModelScope.launch {
                    val article = newsUseCases.selectArticle(event.article.url)
                    if (article == null) {
                        upsertArticle(event.article)
                    } else {
                        deleteArticle(event.article)
                    }
                }
            }

            DetailsEvent.RemoveSideEffect -> {
                sideEffect = null
            }
        }
    }

    fun checkIsSaved(article: Article) {
        viewModelScope.launch {
            _isArticleSaved.value = newsUseCases.selectArticle(article.url) != null
        }
    }

    private suspend fun deleteArticle(article: Article) {
        newsUseCases.deleteArticle(article)
        sideEffect = "Article Deleted"
    }

    private suspend fun upsertArticle(article: Article) {
        newsUseCases.upsertArticle(article)
        sideEffect = "Article Saved"

    }
}