package com.devjn.spaceflightnews.view.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devjn.spaceflightnews.Logger
import com.devjn.spaceflightnews.data.Article
import com.devjn.spaceflightnews.network.ArticleApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsListViewModel(
  private val articleApi: ArticleApi,
) : ViewModel() {
  val articles = MutableLiveData<List<Article>>(emptyList())
  val errorMessage = MutableLiveData<String>()

  fun loadData() = viewModelScope.launch(Dispatchers.IO) {
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