package com.devjn.spaceflightnews

import android.app.Application

class App : Application() {

  override fun onCreate() {
    super.onCreate()
    Logger.useAndroidUtil()
  }

}