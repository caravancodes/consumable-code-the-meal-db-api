package com.frogobox.frogomealsapi.data.source

import android.content.Context
import com.frogobox.frogomealsapi.data.response.Meals

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
class MealRepository(private val remoteDataSource: MealRemoteDataSource) : MealDataSource {

    override fun usingChuckInterceptor(context: Context) {
        remoteDataSource.usingChuckInterceptor(context)
    }

    override fun searchMeal(
        apiKey: String,
        mealName: String,
        callback: MealDataSource.GetRemoteCallback<Meals>
    ) {
        remoteDataSource.searchMeal(apiKey, mealName, callback)
    }

    override fun listAllMeal(
        apiKey: String,
        firstLetter: String,
        callback: MealDataSource.GetRemoteCallback<Meals>
    ) {
        remoteDataSource.listAllMeal(apiKey, firstLetter, callback)
    }

    override fun lookupFullMeal(
        apiKey: String,
        idMeal: String,
        callback: MealDataSource.GetRemoteCallback<Meals>
    ) {
        remoteDataSource.lookupFullMeal(apiKey, idMeal, callback)
    }

    override fun lookupRandomMeal(
        apiKey: String,
        callback: MealDataSource.GetRemoteCallback<Meals>
    ) {
        remoteDataSource.lookupRandomMeal(apiKey, callback)
    }
}