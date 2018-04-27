package com.example.jguzikowski.weatherapp.domain

import com.example.jguzikowski.weatherapp.data.Forecast

/**
 * Created by j.guzikowski on 2/12/18.
 */
data class ForecastList(val city : String, val country : String, val dailyForecast : List<Forecast>)