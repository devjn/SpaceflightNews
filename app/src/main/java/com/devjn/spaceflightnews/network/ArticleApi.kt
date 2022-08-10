package com.devjn.spaceflightnews.network

import com.devjn.spaceflightnews.data.Article
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ArticleApi {
  @GET("articles")
  suspend fun getArticles(@Query("_limit") limit: Int = 7): Response<List<Article>>
}