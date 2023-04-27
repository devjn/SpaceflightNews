package com.devjn.spaceflightnews.view.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import com.devjn.spaceflightnews.data.Article
import com.devjn.spaceflightnews.view.compose.AppTheme
import com.devjn.spaceflightnews.view.compose.ArticleDetailView

class ArticleDetailFragment : Fragment() {

  private lateinit var article: Article

  @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
  @OptIn(ExperimentalMaterial3Api::class)
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ) = ComposeView(requireContext()).apply {
    // Dispose of the Composition when the view's LifecycleOwner is destroyed
    setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
    setContent {
      AppTheme {
        Scaffold(
          topBar = {
            TopAppBar(
              title = { Text(text = "Article") },
              navigationIcon = {
                IconButton(onClick = {
                  parentFragmentManager.popBackStack()
                }) {
                  Icon(Icons.Filled.ArrowBack, "backIcon")
                }
              },
              colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = Color.White,
                navigationIconContentColor = Color.White
              )
            )
          },
          content = {
            ArticleDetailView(article, it)
          }
        )
      }
    }
  }

  companion object {
    fun newInstance(article: Article) = ArticleDetailFragment().apply {
      this.article = article
    }
  }
}
