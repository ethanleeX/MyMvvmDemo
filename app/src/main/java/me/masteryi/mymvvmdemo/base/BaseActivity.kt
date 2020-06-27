/*
 * BaseActivity.kt
 * Copyright 2020 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package me.masteryi.mymvvmdemo.base

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * @author Ethan Lee
 */
abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {
    protected lateinit var binding: T

    abstract fun getLayoutId(): Int

    @CallSuper
    protected open fun initView() {
        binding = DataBindingUtil.setContentView<T>(this, getLayoutId())
    }

    abstract fun initData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()

        initData()
    }
}