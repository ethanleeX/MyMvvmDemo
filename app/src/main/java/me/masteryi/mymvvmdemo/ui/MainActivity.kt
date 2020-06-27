/*
 * MainActivity.kt
 * Copyright 2020 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package me.masteryi.mymvvmdemo.ui

import androidx.activity.viewModels
import me.masteryi.mymvvmdemo.R
import me.masteryi.mymvvmdemo.base.BaseActivity
import me.masteryi.mymvvmdemo.databinding.ActivityMainBinding


class MainActivity : BaseActivity<ActivityMainBinding>() {
    private val viewModel by viewModels<MainViewModel>()

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {

    }

    override fun initView() {
        super.initView()

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.btnGetData.setOnClickListener {
            viewModel.getWeatherData()
        }

        binding.btnGetDataError.setOnClickListener {
            viewModel.getWrongWeatherData()
        }
    }
}