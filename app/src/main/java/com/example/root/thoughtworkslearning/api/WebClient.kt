package com.example.root.thoughtworkslearning.api

import com.example.root.thoughtworkslearning.pattern.model.BaseModel
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class WebClient {


    public var getApi: WebServiceAPI

    init {
        val client = OkHttpClient().newBuilder().build()

        val retrofit = Retrofit.Builder()
                .baseUrl("http://samples.openweathermap.org/data/2.5/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()

        getApi = retrofit.create(WebServiceAPI :: class.java)
    }





    interface WebServiceAPI{

        @GET("weather?q=Bangalore")
        fun getWeather(@Query("appid") id: String): Call<BaseModel>
    }
}