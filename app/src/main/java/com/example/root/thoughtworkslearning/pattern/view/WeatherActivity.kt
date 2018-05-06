package com.example.root.thoughtworkslearning.pattern.view

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.root.thoughtworkslearning.Loader
import com.example.root.thoughtworkslearning.R
import com.example.root.thoughtworkslearning.api.WebClient
import com.example.root.thoughtworkslearning.pattern.model.BaseModel
import com.example.root.thoughtworkslearning.pattern.presenter.ResponcePreenter
import com.example.root.thoughtworkslearning.pattern.presenter.ResponceSupport
import com.example.root.thoughtworkslearning.singleton.AppKey
import kotlinx.android.synthetic.main.activity_weather.*
import okhttp3.Call
import okhttp3.Callback
import retrofit2.Response


class WeatherActivity : AppCompatActivity(), ResponceSupport {

    lateinit var presenter : ResponcePreenter
    lateinit var loading : Loader
    lateinit var context : Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        loading = Loader(this);
        context = this
    }

    override fun onResume() {
        super.onResume()
        presenter = ResponcePreenter(this,WebClient())
        presenter.callWeatherAPI()

        tabButton.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                startActivity(DetailActivity.intance(context))
            }

        })

    }

    override fun updateWeather(weather: BaseModel?,loco:String) {

        title1.text = "Location"
        valu1.setText(loco)

        title2.text = "Temprarature"
        valu2.text = weather?.main?.temp?.toString()

        title3.text = "Pressure"
        valu3.text = weather?.main?.pressure?.toString()

        title4.text = "Humidity"
        valu4.text = weather?.main?.humidity?.toString()

        title5.text = "Weather"
        valu5.text = weather?.weather?.get(0)?.description?.toString()

        title6.text = "Wind Speed"
        valu6.text = weather?.wind?.speed?.toString()

    }

    override fun errorView() {
    }

    override fun showLoader() {
        loading.show()
    }

    override fun hideLoader() {
        loading.hide()
    }

}
