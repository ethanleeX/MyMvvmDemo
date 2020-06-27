/*
 * MainRepository.kt
 * Copyright 2020 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package me.masteryi.mymvvmdemo.ui

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import me.masteryi.mymvvmdemo.base.BaseRepository
import me.masteryi.mymvvmdemo.base.Result
import me.masteryi.mymvvmdemo.model.Weather
import me.masteryi.mymvvmdemo.network.DemoService
import me.masteryi.mymvvmdemo.utils.KeyUtil

/**
 * @author Ethan Lee
 */
class MainRepository : BaseRepository() {
    suspend fun getWeather(): Result<Weather> {
        return safeApiCall {
            withContext(Dispatchers.IO) {
                val data = DemoService.demoApi.getWeatherData("hangzhou", KeyUtil.KEY)
                Result.Success(data)
            }
        }
    }

    suspend fun getWrongWeather(): Result<Weather> {
        val result = safeApiCall {
            withContext(Dispatchers.IO) {
                val data = DemoService.demoApi.getWrongWeatherData("hangzhou", KeyUtil.KEY)
                Result.Success(data)
            }
        }
        return result
    }
}