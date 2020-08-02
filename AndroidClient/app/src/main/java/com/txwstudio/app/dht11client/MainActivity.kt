package com.txwstudio.app.dht11client

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.txwstudio.app.dht11client.ui.weather.WeatherFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val weatherFragment = WeatherFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar_main)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragView_mainActivity, weatherFragment)
        fragmentTransaction.commit()
    }

}