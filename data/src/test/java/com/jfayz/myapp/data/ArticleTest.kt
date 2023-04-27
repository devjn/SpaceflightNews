package com.jfayz.myapp.data

import com.devjn.spaceflightnews.data.Article
import junit.framework.TestCase.assertEquals
import org.junit.Test

class ArticleTest {

  @Test
  fun testAsEpected() {
    val article = Article(
      123,
      "Example Title",
      "https://example.com/article",
      "https://example.com/image.jpg",
      "Example News Site",
      "Example Summary",
      "2023-04-27T12:34:56Z"
    )
    val expectedString =
      "Article(id=123, title=Example Title, url=https://example.com/article, imageUrl=https://example.com/image.jpg, newsSite=Example News Site, summary=Example Summary, publishedAt=2023-04-27T12:34:56Z)"
    val actualString = article.toString()
    assertEquals(expectedString, actualString)
  }
}
