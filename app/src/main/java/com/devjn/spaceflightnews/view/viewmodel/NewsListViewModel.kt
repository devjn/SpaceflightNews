package com.devjn.spaceflightnews.view.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devjn.spaceflightnews.Logger
import com.devjn.spaceflightnews.data.Article
import com.devjn.spaceflightnews.network.ArticleApi
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsListViewModel(
  private val articleApi: ArticleApi
) : ViewModel() {
  val articles = MutableLiveData<List<Article>>(emptyList())
  val errorMessage = MutableLiveData<String>()
  private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
    onError("Exception handled: ${throwable.localizedMessage}")
  }

  fun loadData() = viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
    val response = articleApi.getArticles()
    if (response.isSuccessful) {
      response.body()?.let { articles.postValue(it) }
    } else {
      onError(response.errorBody()?.string() ?: "Unknown error")
    }
  }

  private fun onError(message: String) {
    errorMessage.postValue(message)
    Logger.logError(message)
  }
}
