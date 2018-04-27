package com.example.jguzikowski.weatherapp.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.jguzikowski.weatherapp.App
import org.jetbrains.anko.db.*

/**
 * Created by j.guzikowski on 2/13/18.
 */
class ForecastDbHelper(ctx : Context = App.instance) : ManagedSQLiteOpenHelper(App.instance,ForecastDbHelper.DB_NAME,null,ForecastDbHelper.DB_VERSION)  {
    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
       db.dropTable(DayForecastTable.NAME,true)
        onCreate(db)
    }


    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(DayForecastTable.NAME,true,
                DayForecastTable.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                DayForecastTable.TEMPERATURE to TEXT,
                DayForecastTable.HUMIDITY to TEXT
        )
    }

    companion object {
        val DB_NAME = "forecast.db"
        val DB_VERSION =1
        val instance by lazy {ForecastDbHelper}
    }
}