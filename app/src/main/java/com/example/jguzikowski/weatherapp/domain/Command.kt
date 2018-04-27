package com.example.jguzikowski.weatherapp.domain

/**
 * Created by j.guzikowski on 2/12/18.
 */
public interface Command<T> {
    fun execute():T
}