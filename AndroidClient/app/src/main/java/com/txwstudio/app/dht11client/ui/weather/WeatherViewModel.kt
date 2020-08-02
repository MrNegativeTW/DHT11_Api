package com.txwstudio.app.dht11client.ui.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.txwstudio.app.dht11client.service.WeatherApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {

    val temp = MutableLiveData<String>()
    val hum = MutableLiveData<String>()

    fun getSensorData() {
        viewModelScope.launch(Dispatchers.IO) {
            val data = WeatherApi.retrofitService.getDHT11Data()
            val datas = data.execute().body()

            temp.postValue(datas?.getTemp().toString())
            hum.postValue(datas?.getHum().toString())
        }
    }
}