package com.example.jguzikowski.weatherapp

import android.app.Application

/**
 * Created by j.guzikowski on 2/13/18.
 */
class App : Application() {
    companion object {
      //  private var instance: Application? = null
      //fun instance() = instance!!

        lateinit var instance: App
        private set

    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}