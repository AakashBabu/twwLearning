package com.example.root.thoughtworkslearning.pattern.model

data class BaseModel(val weather: List<Weather>,
                val main: Main,
                val wind: Wind,
                val dt: Int,
                val id: Int,
                val name: String){

    inner class Wind(
            val speed: Double,
            val deg: Int
    )

    inner class Weather(
            val id: Int,
            val main: String,
            val description: String,
            val icon: String
    )

    inner class Main(
            val temp: Double,
            val pressure: Int,
            val humidity: Int,
            val temp_min: Double,
            val temp_max: Double
    )

}