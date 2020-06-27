/*
 * Weather.kt
 * Copyright 2020 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package me.masteryi.mymvvmdemo.model

import com.google.gson.annotations.SerializedName

/**
 * @author Ethan Lee
 */
class Weather {
    inner class HeWeather {
        inner class Now {
            var cond_txt: String? = null // 天气描述
            var tmp: Int? = null // 温度
            var wind_dir: String? = null // 风向
            var wind_sc: String? = null // 风力
            var hum: Int? = null // 相对湿度
        }

        var now: Now? = null
    }

    @SerializedName("HeWeather6")
    var heWeather: Array<HeWeather>? = null
}