package com.devjn.spaceflightnews.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.devjn.spaceflightnews.Provider
import com.devjn.spaceflightnews.R
import com.devjn.spaceflightnews.databinding.FragmentNewsListBinding
import com.devjn.spaceflightnews.network.ArticleApi
import com.devjn.spaceflightnews.view.adapter.ArticleAdapter
import com.devjn.spaceflightnews.view.viewmodel.NewsListViewModel
import com.google.android.material.snackbar.Snackbar

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class NewsListFragment : Fragment(R.layout.fragment_news_list) {

  private val viewModel: NewsListViewModel by viewModels { NewsListModelFactory() }
  private var _binding: FragmentNewsListBinding? = null
  private val binding get() = _binding!!
  private val adapter = ArticleAdapter(emptyList()) {
    parentFragmentManager.commit {
      replace(R.id.fragment_container_view, ArticleDetailFragment.newInstance(it))
      addToBackStack(null)
    }
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentNewsListBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.apply {
      list.adapter = adapter
      fab.setOnClickListener { fab ->
        viewModel.loadData()
        Snackbar.make(fab, R.string.action_articles_refresh, Snackbar.LENGTH_LONG).show()
      }
    }
    viewModel.articles.observe(viewLifecycleOwner) {
      adapter.updateData(it)
    }
    viewModel.errorMessage.observe(viewLifecycleOwner) {
      Snackbar.make(binding.fab, it, Snackbar.LENGTH_LONG)
        .setAction(R.string.action_retry) {
          viewModel.loadData()
        }.show()
    }
    if (savedInstanceState == null) {
      viewModel.loadData()
    }
  }

  @Suppress("UNCHECKED_CAST")
  class NewsListModelFactory(
    private val articleApi: ArticleApi = Provider.provideArticleApi()
  ) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>) = NewsListViewModel(articleApi) as T
  }
}
