package com.devjn.spaceflightnews.utils

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.Matcher

class RecyclerViewItemCountAssertion private constructor(
  private val matcher: Matcher<Int>
) : ViewAssertion {

  override fun check(view: View, noViewFoundException: NoMatchingViewException?) {
    if (noViewFoundException != null) {
      throw noViewFoundException
    }
    val recyclerView = view as RecyclerView
    val adapter = recyclerView.adapter
    assertThat(adapter?.itemCount, matcher)
  }

  companion object {
    @JvmStatic
    fun withItemCount(expectedCount: Int) = withItemCount(`is`(expectedCount))

    @JvmStatic
    fun withItemCount(matcher: Matcher<Int>) = RecyclerViewItemCountAssertion(matcher)
  }
}
