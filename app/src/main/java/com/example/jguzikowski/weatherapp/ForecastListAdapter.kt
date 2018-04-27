package com.example.jguzikowski.weatherapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.jguzikowski.weatherapp.data.Forecast
import kotlinx.android.synthetic.main.item_forecast.view.*

/**
 * Created by j.guzikowski on 2/8/18.
 */
class ForecastListAdapter(val items:List<Forecast>,val itemClickListener: (Forecast) -> Unit) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(items.get(position))
    }

    override fun getItemCount(): Int = items.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{

        val view  = LayoutInflater.from(parent.context).inflate(R.layout.item_forecast,parent,false)

        return ViewHolder(view,itemClickListener)
    }

    class ViewHolder(view : View, val itemClickListener: (Forecast) -> Unit) : RecyclerView.ViewHolder(view){
        private val temperature: TextView
        private val humidity: TextView

        init {
            temperature = view.findViewById(R.id.temperatura)
            humidity = view.findViewById(R.id.humidity)
        }

        fun bindForecast(forecast: Forecast){
            with(forecast){

                //with str 48 pozwala ominac forecast.main.temp.toString()
                //inline fun <T> with(t:T, body T.() -> Unit){t.body()}

                itemView.temperatura.text = main.temp.toString()
                itemView.humidity.text = main.humidity.toString()
                itemView.setOnClickListener{itemClickListener(this)}
            }
        }
    }

    interface OnItemClickListener {
        operator fun invoke(forecast:Forecast)
    }



}