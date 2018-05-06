package com.example.root.thoughtworkslearning.pattern.presenter

import com.example.root.thoughtworkslearning.api.MyCallback
import com.example.root.thoughtworkslearning.api.WebClient
import com.example.root.thoughtworkslearning.pattern.model.BaseModel
import com.example.root.thoughtworkslearning.pattern.view.WeatherActivity
import com.example.root.thoughtworkslearning.singleton.AppKey
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResponcePreenter(val viewSupport : ResponceSupport,val weather: WebClient ){

    lateinit var callback: MyCallback

    fun callWeatherAPI(){
        viewSupport.showLoader()
        weather.getWeather(object : MyCallback{
            override fun onSuccess(baseModel: BaseModel?){
                viewSupport.hideLoader()
                viewSupport.updateWeather(baseModel,"Bangalore")
            }

            override fun onError() {
                viewSupport.hideLoader()
                viewSupport.errorView()
            }

        })


    }



}