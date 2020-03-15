package com.frogobox.frogothemealdbapi

import android.content.Context
import com.frogobox.frogothemealdbapi.callback.MealResultCallback
import com.frogobox.frogothemealdbapi.data.model.*
import com.frogobox.frogothemealdbapi.data.response.CategoryResponse
import com.frogobox.frogothemealdbapi.data.response.MealResponse

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
interface ConsumeTheMealDbApiView {

    // Switch For Using Chuck Interceptor
    fun usingChuckInterceptor(context: Context)

    // Search meal by name
    fun searchMeal(mealName: String, callback: MealResultCallback<MealResponse<Meal>>)

    // List all meals by first letter
    fun listAllMeal(firstLetter: String, callback: MealResultCallback<MealResponse<Meal>>)

    // Lookup full meal details by id
    fun lookupFullMeal(idMeal: String, callback: MealResultCallback<MealResponse<Meal>>)

    // Lookup a single random meal
    fun lookupRandomMeal(callback: MealResultCallback<MealResponse<Meal>>)

    // List all meal categories
    fun listMealCategories(callback: MealResultCallback<CategoryResponse>)

    // List all Categories
    fun listAllCateories(callback: MealResultCallback<MealResponse<Category>>)

    // List all Area
    fun listAllArea(callback: MealResultCallback<MealResponse<Area>>)

    // List all Ingredients
    fun listAllIngredients(callback: MealResultCallback<MealResponse<Ingredient>>)

    // Filter by main ingredient
    fun filterByIngredient(ingredient: String, callback: MealResultCallback<MealResponse<MealFilter>>)

    // Filter by Category
    fun filterByCategory(category: String, callback: MealResultCallback<MealResponse<MealFilter>>)

    // Filter by Area
    fun filterByArea(area: String, callback: MealResultCallback<MealResponse<MealFilter>>)

}