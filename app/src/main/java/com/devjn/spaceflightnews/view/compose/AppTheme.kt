package com.devjn.spaceflightnews.view.compose

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import com.devjn.spaceflightnews.R

@Composable
fun AppTheme(
  content: @Composable () -> Unit
) {
  val lightColorPalette = lightColorScheme(
    primary = colorResource(R.color.primary)
  )
  MaterialTheme(
    colorScheme = lightColorPalette,
    content = content
  )
}
