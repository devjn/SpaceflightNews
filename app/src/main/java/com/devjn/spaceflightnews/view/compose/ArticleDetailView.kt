package com.devjn.spaceflightnews.view.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.devjn.spaceflightnews.data.Article

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ArticleDetailView(newsItem: Article, parentPadding: PaddingValues) {
  Column(
    modifier = Modifier
      .padding(16.dp)
      .padding(parentPadding)
      .fillMaxWidth()
  ) {
    Text(text = newsItem.title, fontSize = 18.sp)
    Spacer(modifier = Modifier.height(8.dp))

    GlideImage(
      model = newsItem.imageUrl,
      contentDescription = "News Image",
      modifier = Modifier
        .fillMaxWidth()
        .height(200.dp),
      contentScale = ContentScale.Crop
    )
    Spacer(modifier = Modifier.height(8.dp))

    Text(text = "Published at: ${newsItem.publishedAt}")
    Text(text = "News Site: ${newsItem.newsSite}")
    Spacer(modifier = Modifier.height(8.dp))

    Text(text = newsItem.summary)
    Spacer(modifier = Modifier.height(16.dp))

    Divider()
  }
}

@Preview(name = "ArticleDetailView")
@Composable
fun SimpleComposablePreview() {
  ArticleDetailView(
    Article(
      0,
      "Title",
      "https://spacenews.com/china-may-include-helicopter-in-mars-sample-return-mission/",
      "https://i0.wp.com/spacenews.com/wp-content/uploads/2021/07/zhurong-backshell-parachute-inspection-CNSA-PEC-15july2021-1.jpg",
      "website",
      "Summary",
      "date"
    ),
    PaddingValues(0.dp)
  )
}
