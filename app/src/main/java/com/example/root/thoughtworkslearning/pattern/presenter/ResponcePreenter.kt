package com.example.root.thoughtworkslearning.pattern.presenter

import com.example.root.thoughtworkslearning.api.MyCallback
import com.example.root.thoughtworkslearning.api.WebClient
import com.example.root.thoughtworkslearning.pattern.model.BaseModel
import com.example.root.thoughtworkslearning.temp.AppKey

class ResponcePreenter(val viewSupport : ResponceSupport,val weather: WebClient ){

    lateinit var callback: MyCallback

    fun callWeatherAPI(){
        viewSupport.showLoader()
        weather.getWeather(object : MyCallback{
            override fun onSuccess(baseModel: BaseModel?){
                viewSupport.hideLoader()
                viewSupport.updateWeather(baseModel,AppKey.city)
            }

            override fun onError() {
                viewSupport.hideLoader()
                viewSupport.errorView()
            }

        })


    }



}