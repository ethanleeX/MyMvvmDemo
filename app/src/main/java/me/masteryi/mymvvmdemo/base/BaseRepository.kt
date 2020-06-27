/*
 * BaseRepository.kt
 * Copyright 2020 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package me.masteryi.mymvvmdemo.base

/**
 * @author Ethan Lee
 */
abstract class BaseRepository {
    suspend fun <T> safeApiCall(call: suspend () -> Result<T>): Result<T> {
        return try {
            call()
        } catch (e: Exception) {
            e.printStackTrace()
            Result.Error(e)
        }
    }
}