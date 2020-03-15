package com.frogobox.frogomealsapi

import android.content.Context
import com.frogobox.frogomealsapi.callback.MealResultCallback
import com.frogobox.frogomealsapi.data.response.Meals
import com.frogobox.frogomealsapi.data.source.MealDataSource
import com.frogobox.frogomealsapi.data.source.MealRemoteDataSource
import com.frogobox.frogomealsapi.data.source.MealRepository

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * consumable-code-the-meal-db-api
 * Copyright (C) 15/03/2020.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.frogomealsapi
 *
 */
class ConsumeMealApi(private val apiKey: String) : ConsumeMealApiView {

    private val repository = MealRepository(MealRemoteDataSource)

    override fun usingChuckInterceptor(context: Context) {
        repository.usingChuckInterceptor(context)
    }

    override fun searchMeal(mealName: String, callback: MealResultCallback<Meals>) {
        repository.searchMeal(apiKey, mealName, object : MealDataSource.GetRemoteCallback<Meals> {
            override fun onSuccess(data: Meals) {
                callback.getResultData(data)
            }

            override fun onFailed(statusCode: Int, errorMessage: String?) {
                callback.failedResult(statusCode, errorMessage)
            }
        })
    }

    override fun listAllMeal(firstLetter: String, callback: MealResultCallback<Meals>) {
        repository.listAllMeal(
            apiKey,
            firstLetter,
            object : MealDataSource.GetRemoteCallback<Meals> {
                override fun onSuccess(data: Meals) {
                    callback.getResultData(data)
                }

                override fun onFailed(statusCode: Int, errorMessage: String?) {
                    callback.failedResult(statusCode, errorMessage)
                }
            })
    }

    override fun lookupFullMeal(idMeal: String, callback: MealResultCallback<Meals>) {
        repository.lookupFullMeal(apiKey, idMeal, object : MealDataSource.GetRemoteCallback<Meals> {
            override fun onSuccess(data: Meals) {
                callback.getResultData(data)
            }

            override fun onFailed(statusCode: Int, errorMessage: String?) {
                callback.failedResult(statusCode, errorMessage)
            }
        })
    }

    override fun lookupRandomMeal(callback: MealResultCallback<Meals>) {
        repository.lookupRandomMeal(apiKey, object : MealDataSource.GetRemoteCallback<Meals> {
            override fun onSuccess(data: Meals) {
                callback.getResultData(data)
            }

            override fun onFailed(statusCode: Int, errorMessage: String?) {
                callback.failedResult(statusCode, errorMessage)
            }
        })
    }
}