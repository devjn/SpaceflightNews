package com.devjn.spaceflightnews

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.viewbinding.ViewBinding
import com.devjn.spaceflightnews.utils.RecyclerViewItemCountAssertion.Companion.withItemCount
import com.devjn.spaceflightnews.view.adapter.BindingAdapter
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

  @get:Rule
  val activityRule = ActivityScenarioRule(MainActivity::class.java)

  @Test
  fun actionBarIsDisplayed() {
    onView(withText("Space flight news")).check(matches(isDisplayed()))
  }

  @Test
  fun testListClick() {
    onView(withId(R.id.list))
      .check(withItemCount(10))
      .perform(
        RecyclerViewActions.actionOnItemAtPosition<BindingAdapter.BindViewHolder<ViewBinding>>(
          2,
          click()
        )
      )
  }
}
