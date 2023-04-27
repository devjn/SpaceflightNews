package com.devjn.spaceflightnews.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.devjn.spaceflightnews.data.Article
import com.devjn.spaceflightnews.databinding.ListItemArticleBinding

class ArticleAdapter(
  items: List<Article>,
  private val clickListener: (Article) -> Unit
) : BindingAdapter<ListItemArticleBinding, Article>(items) {
  override fun inflate(inflater: LayoutInflater, parent: ViewGroup) = ListItemArticleBinding
    .inflate(inflater, parent, false)

  override fun bind(binding: ListItemArticleBinding, item: Article) {
    binding.apply {
      root.setOnClickListener { clickListener.invoke(item) }
      txtTitle.text = item.title
      txtSummary.text = item.summary
      Glide.with(binding.root).load(item.imageUrl).centerCrop().into(binding.image)
    }
  }
}
