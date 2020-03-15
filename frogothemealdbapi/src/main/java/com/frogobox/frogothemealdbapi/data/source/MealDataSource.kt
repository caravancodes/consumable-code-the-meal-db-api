package com.frogobox.frogothemealdbapi.data.source

import android.content.Context
import com.frogobox.frogothemealdbapi.base.BaseMealDataSource
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
interface MealDataSource {

    // Switch For Using Chuck Interceptor
    fun usingChuckInterceptor(context: Context)

    // Search meal by name
    fun searchMeal(apiKey: String, mealName: String, callback: GetRemoteCallback<MealResponse<Meal>>)

    // List all meals by first letter
    fun listAllMeal(apiKey: String, firstLetter: String, callback: GetRemoteCallback<MealResponse<Meal>>)

    // Lookup full meal details by id
    fun lookupFullMeal(apiKey: String, idMeal: String, callback: GetRemoteCallback<MealResponse<Meal>>)

    // Lookup a single random meal
    fun lookupRandomMeal(apiKey: String, callback: GetRemoteCallback<MealResponse<Meal>>)

    // List all meal categories
    fun listMealCategories(apiKey: String, callback: GetRemoteCallback<CategoryResponse>)

    // List all Categories
    fun listAllCateories(apiKey: String, callback: GetRemoteCallback<MealResponse<Category>>)

    // List all Area
    fun listAllArea(apiKey: String, callback: GetRemoteCallback<MealResponse<Area>>)

    // List all Ingredients
    fun listAllIngredients(apiKey: String, callback: GetRemoteCallback<MealResponse<Ingredient>>)

    // Filter by main ingredient
    fun filterByIngredient(apiKey: String, ingredient: String, callback: GetRemoteCallback<MealResponse<MealFilter>>)

    // Filter by Category
    fun filterByCategory(apiKey: String, category: String, callback: GetRemoteCallback<MealResponse<MealFilter>>)

    // Filter by Area
    fun filterByArea(apiKey: String, area: String, callback: GetRemoteCallback<MealResponse<MealFilter>>)

    // Response Callback
    interface GetRemoteCallback<T> : BaseMealDataSource.ResponseCallback<T>

}