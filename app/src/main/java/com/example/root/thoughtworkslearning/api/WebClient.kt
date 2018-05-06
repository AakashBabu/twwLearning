package com.example.root.thoughtworkslearning.api

import com.example.root.thoughtworkslearning.pattern.model.BaseModel
import com.example.root.thoughtworkslearning.singleton.AppKey
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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


    fun getWeather(callback: MyCallback){
        getApi.getWeather(AppKey.key).enqueue((object: retrofit2.Callback<BaseModel> {
            override fun onFailure(call: Call<BaseModel>?, t: Throwable?) {
                callback.onError()
            }

            override fun onResponse(call: Call<BaseModel>?, response: Response<BaseModel>?) {
                callback.onSuccess(response?.body() as BaseModel)
            }

        }))
    }



    interface WebServiceAPI{

        @GET("weather?q=Bangalore")
        fun getWeather(@Query("appid") id: String): Call<BaseModel>
    }
}