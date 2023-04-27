package com.devjn.spaceflightnews.view.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.devjn.spaceflightnews.data.Article
import com.devjn.spaceflightnews.network.ArticleApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import retrofit2.Response

class NewsListViewModelTest {
  @get:Rule
  val instantExecutorRule = InstantTaskExecutorRule()

  private val articleApi: ArticleApi = mock()

  private val sut = NewsListViewModel(articleApi)

  private val articles: List<Article> = listOf(Article(0, "", "", "", "", "", ""))
  private val responseSuccessful: Response<List<Article>> = Response.success(articles)
  private val responseFail: Response<List<Article>> = Response.error(404, "Not found".toResponseBody())

  @Before
  fun setup() {
    Dispatchers.setMain(StandardTestDispatcher())
  }

  @Test
  fun `when loadData and successful response return articles`() = runTest {
    whenever(articleApi.getArticles(any())).thenReturn(responseSuccessful)

    sut.loadData()

    val observer: Observer<List<Article>> = mock()
    sut.articles.observeForever(observer)
    verify(observer).onChanged(any())
    sut.articles.removeObserver(observer)

    verify(articleApi).getArticles(any())
    assertEquals(articles, sut.articles.value)
    assertNull(sut.errorMessage.value)
  }

  @Test
  fun `when loadData and NOT successful response then error`() = runTest {
    whenever(articleApi.getArticles(any())).thenReturn(responseFail)

    sut.loadData()

    verify(articleApi).getArticles(any())
    assertTrue(sut.articles.value!!.isEmpty())

    val observer: Observer<String> = mock()
    sut.errorMessage.observeForever(observer)
    verify(observer).onChanged(any())
    sut.errorMessage.removeObserver(observer)
  }

  @After
  fun tearDown() {
    Dispatchers.resetMain()
    sut.apply {
      sut.articles.value = emptyList()
      errorMessage.value = null
    }
  }
}
