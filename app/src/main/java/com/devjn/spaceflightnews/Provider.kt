package com.devjn.spaceflightnews

import com.devjn.spaceflightnews.network.ArticleApi
import com.devjn.spaceflightnews.network.RetrofitModule

object Provider {

  fun provideArticleApi(): ArticleApi = RetrofitModule.getInstance().create(ArticleApi::class.java)

}