package com.frogobox.frogothemealdbapi.data.source

import android.content.Context
import com.frogobox.frogothemealdbapi.data.model.*
import com.frogobox.frogothemealdbapi.data.response.*

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
        callback: MealDataSource.GetRemoteCallback<MealResponse<Meal>>
    ) {
        remoteDataSource.searchMeal(apiKey, mealName, callback)
    }

    override fun listAllMeal(
        apiKey: String,
        firstLetter: String,
        callback: MealDataSource.GetRemoteCallback<MealResponse<Meal>>
    ) {
        remoteDataSource.listAllMeal(apiKey, firstLetter, callback)
    }

    override fun lookupFullMeal(
        apiKey: String,
        idMeal: String,
        callback: MealDataSource.GetRemoteCallback<MealResponse<Meal>>
    ) {
        remoteDataSource.lookupFullMeal(apiKey, idMeal, callback)
    }

    override fun lookupRandomMeal(
        apiKey: String,
        callback: MealDataSource.GetRemoteCallback<MealResponse<Meal>>
    ) {
        remoteDataSource.lookupRandomMeal(apiKey, callback)
    }

    override fun listMealCategories(
        apiKey: String,
        callback: MealDataSource.GetRemoteCallback<CategoryResponse>
    ) {
        remoteDataSource.listMealCategories(apiKey, callback)
    }

    override fun listAllCateories(
        apiKey: String,
        callback: MealDataSource.GetRemoteCallback<MealResponse<Category>>
    ) {
        remoteDataSource.listAllCateories(apiKey, callback)
    }

    override fun listAllArea(
        apiKey: String,
        callback: MealDataSource.GetRemoteCallback<MealResponse<Area>>
    ) {
        remoteDataSource.listAllArea(apiKey, callback)
    }

    override fun listAllIngredients(
        apiKey: String,
        callback: MealDataSource.GetRemoteCallback<MealResponse<Ingredient>>
    ) {
        remoteDataSource.listAllIngredients(apiKey, callback)
    }

    override fun filterByIngredient(
        apiKey: String,
        ingredient: String,
        callback: MealDataSource.GetRemoteCallback<MealResponse<MealFilter>>
    ) {
        remoteDataSource.filterByIngredient(apiKey, ingredient, callback)
    }
}