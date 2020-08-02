package com.txwstudio.app.dht11client.model

import com.google.gson.annotations.SerializedName

data class WeatherJson(
    @SerializedName("humidity") val humidity: Int?,
    @SerializedName("temperature") val temperature: Int?
) {
    fun getTemp(): Int? {
        return if (isValueNull()) 0 else temperature
    }

    fun getHum(): Int? {
        return if (isValueNull()) 0 else humidity
    }

    private fun isValueNull(): Boolean {
        return temperature == null || humidity == null
    }
}