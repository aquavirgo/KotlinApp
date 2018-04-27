package com.example.jguzikowski.weatherapp.database

/**
 * Created by j.guzikowski on 2/15/18.
 */
class DayForecast(var map:MutableMap<String,Any?>) {
    var _id: Long by map
    var temperature: Float by map
    var humidity : Float by map



    constructor(temperature : Float, humidity : Float) : this (HashMap()){
        this.temperature = temperature
        this.humidity = humidity
    }
}


