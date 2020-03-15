package com.frogobox.frogomealsapi

import android.content.Context
import com.frogobox.frogomealsapi.callback.MealResultCallback
import com.frogobox.frogomealsapi.data.response.Meals
import com.frogobox.frogomealsapi.data.source.MealDataSource

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
interface ConsumeMealApiView {

    // Switch For Using Chuck Interceptor
    fun usingChuckInterceptor(context: Context)

    // Search meal by name
    fun searchMeal(mealName: String, callback: MealResultCallback<Meals>)

    // List all meals by first letter
    fun listAllMeal(firstLetter: String, callback: MealResultCallback<Meals>)

    // Lookup full meal details by id
    fun lookupFullMeal(idMeal: String, callback: MealResultCallback<Meals>)

    // Lookup a single random meal
    fun lookupRandomMeal(callback: MealResultCallback<Meals>)

}