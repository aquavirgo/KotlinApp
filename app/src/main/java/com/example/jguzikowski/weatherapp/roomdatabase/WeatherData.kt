package com.example.jguzikowski.weatherapp.roomdatabase

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by j.guzikowski on 2/23/18.
 */

@Entity(tableName = "weatherData")
data class WeatherData(@PrimaryKey(autoGenerate = true) var id : Long?,
                       @ColumnInfo(name = "temperatura") var temp: Float,
                       @ColumnInfo(name = "humidity") var hum: Float,
                       @ColumnInfo(name =  "pressure") var pres: Float

) {
    constructor():this(null,0.0F, 0.0F,0.0F)
}
