package com.example.jguzikowski.weatherapp.domain

import com.example.jguzikowski.weatherapp.Request

/*
 * Created by j.guzikowski on 2/12/18.
 */
class RequestForecastCommand(private val url : String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = Request(url)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute2())
    }
}