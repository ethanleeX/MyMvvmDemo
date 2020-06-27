package me.masteryi.mymvvmdemo.network

import me.masteryi.mymvvmdemo.model.Weather
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Ethan Lee
 */
interface DemoApi {
    @GET("/s6/weather/now")
    suspend fun getWeatherData(
        @Query("location") location: String,
        @Query("key") key: String
    ): Weather

    @GET("/s6123/weather/now")
    suspend fun getWrongWeatherData(
        @Query("location") location: String,
        @Query("key") key: String
    ): Weather
}