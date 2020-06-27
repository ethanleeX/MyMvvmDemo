/*
 * MainViewModel.kt
 * Copyright 2020 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package me.masteryi.mymvvmdemo.ui

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.masteryi.mymvvmdemo.base.Result
import me.masteryi.mymvvmdemo.model.Weather
import retrofit2.HttpException

/**
 * @author Ethan Lee
 */
class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = MainRepository()
    private val weatherData = MutableLiveData<Weather>()
    val weatherInfo = weatherData.map {
        it?.heWeather?.get(0)?.now?.let { now ->
            "天气：${now.cond_txt} 湿度：${now.hum} 温度：${now.tmp}"
        } ?: ""
    }

    fun getWeatherData() {
        viewModelScope.launch(Dispatchers.Main) {
            when (val data: Result<Weather> = repository.getWeather()) {
                is Result.Success -> {
                    weatherData.value = data.data
                }
                else -> {
                    // TODO:
                }
            }
        }
    }

    fun getWrongWeatherData() {
        viewModelScope.launch(Dispatchers.Main) {
            when (val data: Result<Weather> = repository.getWrongWeather()) {
                is Result.Success -> {
                    weatherData.value = data.data
                }
                is Result.Error -> {
                    Toast.makeText(
                        getApplication(),
                        "error ${(data.exception as HttpException).code()}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}