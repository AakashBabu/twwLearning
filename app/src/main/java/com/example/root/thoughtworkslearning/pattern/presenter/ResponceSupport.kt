package com.example.root.thoughtworkslearning.pattern.presenter

import com.example.root.thoughtworkslearning.pattern.model.BaseModel

interface ResponceSupport {

    fun updateWeather(weather: BaseModel?,loco:String)
    fun errorView()
    fun showLoader()
    fun hideLoader()

}