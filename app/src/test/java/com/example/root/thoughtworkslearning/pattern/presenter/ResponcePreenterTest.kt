package com.example.root.thoughtworkslearning.pattern.presenter

import com.example.root.thoughtworkslearning.api.MyCallback
import com.example.root.thoughtworkslearning.api.WebClient
import com.example.root.thoughtworkslearning.pattern.model.BaseModel
import com.nhaarman.mockito_kotlin.*
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import retrofit2.Call

class ResponcePreenterTest {

    lateinit var view : ResponceSupport
    lateinit var presenter : ResponcePreenter
    lateinit var apiCall: WebClient
    @Captor lateinit var callbackCaptor: ArgumentCaptor<MyCallback>

    @Before
    fun setUp() {
        view = mock {  }
        apiCall = mock{ }
        presenter = ResponcePreenter(view,apiCall)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun callWeatherAPI() {
        verify(view).showLoader()
        verify(apiCall.getWeather(capture(callbackCaptor)))

        verify(callbackCaptor.value.onSuccess(any()))
        verify(view).hideLoader()
        verify(view.updateWeather(any(),"Bangalore"))
    }

    @Test
    fun getViewSupport() {
    }

    @Test
    fun getWeather() {
    }
}