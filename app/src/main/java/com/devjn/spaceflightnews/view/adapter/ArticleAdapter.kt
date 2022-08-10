package com.devjn.spaceflightnews.view.adapter

import com.bumptech.glide.Glide
import com.devjn.spaceflightnews.R
import com.devjn.spaceflightnews.data.Article
import com.devjn.spaceflightnews.databinding.ListItemArticleBinding

class ArticleAdapter(items: List<Article>) : BindingAdapter<ListItemArticleBinding, Article>(items) {
  override val layoutId = R.layout.list_item_article

  override fun bind(binding: ListItemArticleBinding, article: Article) {
    binding.article = article
    binding.executePendingBindings()
    Glide.with(binding.root).load(article.imageUrl).centerCrop().into(binding.image)
  }
}