package com.example.jguzikowski.weatherapp.roomdatabase

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

/**
 * Created by j.guzikowski on 2/23/18.
 */
@Database(entities = arrayOf(WeatherData::class), version = 1)
abstract class WeatherDataBase : RoomDatabase() {

    abstract fun weatherDataDao(): WeatherDataDao

    companion object {
        private var INSTANCE: WeatherDataBase? = null

        fun getInstance(context: Context): WeatherDataBase? {
            if (INSTANCE == null) {
                synchronized(WeatherDataBase::class) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WeatherDataBase::class.java, "weather.db")
                            .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}