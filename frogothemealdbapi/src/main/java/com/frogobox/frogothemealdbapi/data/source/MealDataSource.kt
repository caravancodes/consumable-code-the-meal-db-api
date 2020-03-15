package com.frogobox.frogothemealdbapi.data.source

import android.content.Context
import com.frogobox.frogothemealdbapi.base.BaseMealDataSource
import com.frogobox.frogothemealdbapi.data.response.Meals

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
 * com.frogobox.frogomealsapi.data.source
 *
 */
interface MealDataSource {

    // Switch For Using Chuck Interceptor
    fun usingChuckInterceptor(context: Context)

    // Search meal by name
    fun searchMeal(apiKey: String, mealName: String, callback: GetRemoteCallback<Meals>)

    // List all meals by first letter
    fun listAllMeal(apiKey: String, firstLetter: String, callback: GetRemoteCallback<Meals>)

    // Lookup full meal details by id
    fun lookupFullMeal(apiKey: String, idMeal: String, callback: GetRemoteCallback<Meals>)

    // Lookup a single random meal
    fun lookupRandomMeal(apiKey: String, callback: GetRemoteCallback<Meals>)

    // Response Callback
    interface GetRemoteCallback<T> : BaseMealDataSource.ResponseCallback<T>

}