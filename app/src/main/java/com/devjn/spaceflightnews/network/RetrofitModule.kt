package com.devjn.spaceflightnews.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitModule {

  private const val baseUrl = "https://api.spaceflightnewsapi.net/v3/"

  fun getInstance(): Retrofit {
    return Retrofit.Builder().baseUrl(baseUrl)
      .addConverterFactory(GsonConverterFactory.create())
      // we need to add converter factory to
      // convert JSON object to Java object
      .build()
  }
}