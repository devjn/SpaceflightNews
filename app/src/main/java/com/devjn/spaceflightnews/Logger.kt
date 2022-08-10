package com.devjn.spaceflightnews

import android.util.Log

// simple logging abstraction
object Logger : Logging {
  const val TAG = "SPACENEWS"

  private var logging: Logging? = null

  fun useAndroidUtil() {
    logging = AndroidUtilLogging()
  }

  override fun logError(message: String) {
    logging?.logError(message)
  }
}

interface Logging {
  fun logError(message: String)
}

class AndroidUtilLogging : Logging {
  override fun logError(message: String) {
    Log.e(Logger.TAG, message)
  }
}