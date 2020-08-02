package com.txwstudio.app.dht11client.service

import com.txwstudio.app.dht11client.model.WeatherJson
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

private const val BASE_URL = "http://192.168.1.138:5001/"

private val okHttpClient = OkHttpClient.Builder()
    .connectTimeout(10, TimeUnit.SECONDS)
    .readTimeout(10, TimeUnit.SECONDS)
    .build()

private val retrofit = Retrofit.Builder().client(okHttpClient)
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface DHT11Service {
    @GET("api/v1/temp+hum")
    fun getDHT11Data(): Call<WeatherJson>
}


object WeatherApi {
    val retrofitService: DHT11Service by lazy {
        retrofit.create(DHT11Service::class.java)
    }
}