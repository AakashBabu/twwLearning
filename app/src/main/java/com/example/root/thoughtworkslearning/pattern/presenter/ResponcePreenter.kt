package com.example.root.thoughtworkslearning.pattern.presenter

import com.example.root.thoughtworkslearning.pattern.model.BaseModel
import com.example.root.thoughtworkslearning.pattern.view.WeatherActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResponcePreenter(val viewSupport : ResponceSupport,val weather: Call<BaseModel> ){

    fun callWeatherAPI(){
        viewSupport.showLoader()
        weather.enqueue(object: Callback<BaseModel>{
            override fun onFailure(call: Call<BaseModel>?, t: Throwable?) {
                viewSupport.hideLoader()
                viewSupport.errorView()
            }

            override fun onResponse(call: Call<BaseModel>?, response: Response<BaseModel>?) {
                viewSupport.hideLoader()
                viewSupport.updateWeather(response?.body() as BaseModel,"Bangalore")
            }

        })
    }

}