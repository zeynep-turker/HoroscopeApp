package com.example.retrofitproject.service

import com.example.retrofitproject.model.HoroscopeModel
import retrofit2.Call
import retrofit2.http.GET

interface HoroscopeAPI {
    @GET("horoscope.json")
    fun getData(): Call<List<HoroscopeModel>>
}