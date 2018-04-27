package com.example.jguzikowski.weatherapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.jguzikowski.weatherapp.domain.ForecastList
import com.example.jguzikowski.weatherapp.domain.RequestForecastCommand
import com.example.jguzikowski.weatherapp.roomdatabase.WeatherData
import com.example.jguzikowski.weatherapp.roomdatabase.WeatherDataBase
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread


class MainActivity : AppCompatActivity() {
    private var mDb: WeatherDataBase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        message.text = "Hello Kotlin!"
        mDb = WeatherDataBase.getInstance(this)

        //toast("Tost1")
        //niceToast("Toast2")


        forecast_list.layoutManager = LinearLayoutManager(this)

        val items = listOf("Mon 6/23 - Sunny - 31/17",
                "Tue 6/24 - Foggy - 31/17",
                "Mon 6/25 - Sunny - 21/8",
                "Wed 6/26 - Foggy - 31/17",
                "Thurs 6/23 - Sunny - 31/17",
                "Fri 6/24 - Foggy - 31/17",
                "Sat 6/25 - Sunny - 21/8",
                "Sun 6/26 - Foggy - 31/17"
        )

        val url = "http://samples.openweathermap.org/data/2.5/forecast?id=524901&appid=b1b15e88fa797225412429c1c50c122a1"




        doAsync {
            val forecast = RequestForecastCommand(url).execute()
            insertWeatherDataInDb( forecast)

            uiThread {
                forecast_list.adapter = ForecastListAdapter(forecast.dailyForecast) {
                   toast(it.main.temp.toString())
                }
            }


            // forecast_list.adapter = ForecastListAdapter(items)

        }


        fetchWeatherDataFromDb()



    }

    fun toast(message: String, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, length).show()
    }

    fun niceToast(message: String, tag: String = MainActivity::class.java.simpleName, length: Int = Toast.LENGTH_SHORT)
            = Toast.makeText(this, "[$tag] $message", length).show()



    fun insertWeatherDataInDb(forecastList: ForecastList) {

        doAsync {
            val listSize = forecastList.dailyForecast.size

            for (i in forecastList.dailyForecast) {
                val weatherData = WeatherData(null, i.main.temp, i.main.humidity, i.main.pressure)
                mDb?.weatherDataDao()?.insert(weatherData)
            }


           /* forecastList.dailyForecast.filter { it.main.temp > 270 }.forEach {
                println(it.toString())
            }*/


            println(forecastList.dailyForecast.groupBy { it.main.temp })


        }

    }


    private fun fetchWeatherDataFromDb() {
        doAsync {
            val weatherData =
                    mDb?.weatherDataDao()?.getAll()

            if (weatherData == null || weatherData?.size == 0) {
                niceToast("No data in cache..!!")
            } else {
                var weatherData2 = weatherData?.map { it.temp}.max()


                uiThread {
                   message.text = weatherData2.toString()
                }
            }


        }
    }
}


