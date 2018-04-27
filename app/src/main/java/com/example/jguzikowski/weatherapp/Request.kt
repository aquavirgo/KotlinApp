package com.example.jguzikowski.weatherapp

import android.util.Log
import com.example.jguzikowski.weatherapp.data.ForecastResult
import com.google.gson.Gson
import java.net.URL

/**
 * Created by j.guzikowski on 2/9/18.
 */
class Request(private val url:String) {
    fun run(){
        val forecastJsonStr = URL(url).readText()

        Log.d(javaClass.simpleName,forecastJsonStr)
    }

    fun execute(): ForecastResult{
    val forecastJsonStr = URL(url).readText()
    return Gson().fromJson(forecastJsonStr,ForecastResult::class.java)
    }

    fun execute2() = Gson().fromJson(URL(url).readText(),ForecastResult::class.java)


}