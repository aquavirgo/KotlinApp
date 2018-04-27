package com.example.jguzikowski.weatherapp.domain

import com.example.jguzikowski.weatherapp.data.ForecastResult

/**
 * Created by j.guzikowski on 2/12/18.
 */
 class ForecastDataMapper {

    fun convertFromDataModel(forecast : ForecastResult) : ForecastList{
        return ForecastList(forecast.city.name,forecast.city.country,forecast.list)
    }




}