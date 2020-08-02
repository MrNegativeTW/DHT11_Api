package com.txwstudio.app.dht11client.ui.weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.txwstudio.app.dht11client.R
import com.txwstudio.app.dht11client.databinding.FragmentWeatherBinding

class WeatherFragment : Fragment() {

    companion object {
        fun newInstance() = WeatherFragment()
    }

    private lateinit var weatherViewModel: WeatherViewModel
    private lateinit var binding: FragmentWeatherBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        weatherViewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_weather,
            container,
            false
        )
        binding.viewModel = weatherViewModel
        binding.lifecycleOwner = this

        init()

        return binding.root
    }

    private fun init() {
        weatherViewModel.getSensorData()
    }
}