package com.devjn.spaceflightnews.data

data class Article(
  val id: Int,
  val title: String,
  val url: String,
  val imageUrl: String,
  val newsSite: String,
  val summary: String,
  val publishedAt: String
)
