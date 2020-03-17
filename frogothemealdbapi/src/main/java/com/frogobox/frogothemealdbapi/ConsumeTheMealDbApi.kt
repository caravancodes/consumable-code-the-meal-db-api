package com.frogobox.frogothemealdbapi

import android.content.Context
import com.frogobox.frogothemealdbapi.callback.MealResultCallback
import com.frogobox.frogothemealdbapi.data.model.*
import com.frogobox.frogothemealdbapi.data.response.CategoryResponse
import com.frogobox.frogothemealdbapi.data.response.MealResponse
import com.frogobox.frogothemealdbapi.data.source.MealDataSource
import com.frogobox.frogothemealdbapi.data.source.MealRemoteDataSource
import com.frogobox.frogothemealdbapi.data.source.MealRepository

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
class ConsumeTheMealDbApi(private val apiKey: String) : ConsumeTheMealDbApiView {

    private val repository = MealRepository(MealRemoteDataSource)

    override fun usingChuckInterceptor(context: Context) {
        repository.usingChuckInterceptor(context)
    }

    override fun searchMeal(mealName: String, callback: MealResultCallback<MealResponse<Meal>>) {
        repository.searchMeal(
            apiKey,
            mealName,
            object : MealDataSource.GetRemoteCallback<MealResponse<Meal>> {
                override fun onSuccess(data: MealResponse<Meal>) {
                    callback.getResultData(data)
                }

                override fun onFailed(statusCode: Int, errorMessage: String?) {
                    callback.failedResult(statusCode, errorMessage)
                }

                override fun onShowProgress() {
                    callback.onShowProgress()
                }

                override fun onHideProgress() {
                    callback.onHideProgress()
                }
            })
    }

    override fun listAllMeal(
        firstLetter: String,
        callback: MealResultCallback<MealResponse<Meal>>
    ) {
        repository.listAllMeal(
            apiKey,
            firstLetter,
            object : MealDataSource.GetRemoteCallback<MealResponse<Meal>> {
                override fun onSuccess(data: MealResponse<Meal>) {
                    callback.getResultData(data)
                }

                override fun onFailed(statusCode: Int, errorMessage: String?) {
                    callback.failedResult(statusCode, errorMessage)
                }

                override fun onShowProgress() {
                    callback.onShowProgress()
                }

                override fun onHideProgress() {
                    callback.onHideProgress()
                }
            })
    }

    override fun lookupFullMeal(idMeal: String, callback: MealResultCallback<MealResponse<Meal>>) {
        repository.lookupFullMeal(
            apiKey,
            idMeal,
            object : MealDataSource.GetRemoteCallback<MealResponse<Meal>> {
                override fun onSuccess(data: MealResponse<Meal>) {
                    callback.getResultData(data)
                }

                override fun onFailed(statusCode: Int, errorMessage: String?) {
                    callback.failedResult(statusCode, errorMessage)
                }

                override fun onShowProgress() {
                    callback.onShowProgress()
                }

                override fun onHideProgress() {
                    callback.onHideProgress()
                }
            })
    }

    override fun lookupRandomMeal(callback: MealResultCallback<MealResponse<Meal>>) {
        repository.lookupRandomMeal(
            apiKey,
            object : MealDataSource.GetRemoteCallback<MealResponse<Meal>> {
                override fun onSuccess(data: MealResponse<Meal>) {
                    callback.getResultData(data)
                }

                override fun onFailed(statusCode: Int, errorMessage: String?) {
                    callback.failedResult(statusCode, errorMessage)
                }

                override fun onShowProgress() {
                    callback.onShowProgress()
                }

                override fun onHideProgress() {
                    callback.onHideProgress()
                }
            })
    }

    override fun listMealCategories(callback: MealResultCallback<CategoryResponse>) {
        repository.listMealCategories(
            apiKey,
            object : MealDataSource.GetRemoteCallback<CategoryResponse> {
                override fun onSuccess(data: CategoryResponse) {
                    callback.getResultData(data)
                }

                override fun onFailed(statusCode: Int, errorMessage: String?) {
                    callback.failedResult(statusCode, errorMessage)
                }

                override fun onShowProgress() {
                    callback.onShowProgress()
                }

                override fun onHideProgress() {
                    callback.onHideProgress()
                }
            })
    }

    override fun listAllCateories(callback: MealResultCallback<MealResponse<Category>>) {
        repository.listAllCateories(
            apiKey,
            object : MealDataSource.GetRemoteCallback<MealResponse<Category>> {
                override fun onSuccess(data: MealResponse<Category>) {
                    callback.getResultData(data)
                }

                override fun onFailed(statusCode: Int, errorMessage: String?) {
                    callback.failedResult(statusCode, errorMessage)
                }

                override fun onShowProgress() {
                    callback.onShowProgress()
                }

                override fun onHideProgress() {
                    callback.onHideProgress()
                }
            })
    }

    override fun listAllArea(callback: MealResultCallback<MealResponse<Area>>) {
        repository.listAllArea(
            apiKey,
            object : MealDataSource.GetRemoteCallback<MealResponse<Area>> {
                override fun onSuccess(data: MealResponse<Area>) {
                    callback.getResultData(data)
                }

                override fun onFailed(statusCode: Int, errorMessage: String?) {
                    callback.failedResult(statusCode, errorMessage)
                }

                override fun onShowProgress() {
                    callback.onShowProgress()
                }

                override fun onHideProgress() {
                    callback.onHideProgress()
                }
            })
    }

    override fun listAllIngredients(callback: MealResultCallback<MealResponse<Ingredient>>) {
        repository.listAllIngredients(
            apiKey,
            object : MealDataSource.GetRemoteCallback<MealResponse<Ingredient>> {
                override fun onSuccess(data: MealResponse<Ingredient>) {
                    callback.getResultData(data)
                }

                override fun onFailed(statusCode: Int, errorMessage: String?) {
                    callback.failedResult(statusCode, errorMessage)
                }

                override fun onShowProgress() {
                    callback.onShowProgress()
                }

                override fun onHideProgress() {
                    callback.onHideProgress()
                }
            })
    }

    override fun filterByIngredient(
        ingredient: String,
        callback: MealResultCallback<MealResponse<MealFilter>>
    ) {
        repository.filterByIngredient(
            apiKey,
            ingredient,
            object : MealDataSource.GetRemoteCallback<MealResponse<MealFilter>> {
                override fun onSuccess(data: MealResponse<MealFilter>) {
                    callback.getResultData(data)
                }

                override fun onFailed(statusCode: Int, errorMessage: String?) {
                    callback.failedResult(statusCode, errorMessage)
                }

                override fun onShowProgress() {
                    callback.onShowProgress()
                }

                override fun onHideProgress() {
                    callback.onHideProgress()
                }
            })
    }

    override fun filterByCategory(
        category: String,
        callback: MealResultCallback<MealResponse<MealFilter>>
    ) {
        repository.filterByCategory(
            apiKey,
            category,
            object : MealDataSource.GetRemoteCallback<MealResponse<MealFilter>> {
                override fun onSuccess(data: MealResponse<MealFilter>) {
                    callback.getResultData(data)
                }

                override fun onFailed(statusCode: Int, errorMessage: String?) {
                    callback.failedResult(statusCode, errorMessage)
                }

                override fun onShowProgress() {
                    callback.onShowProgress()
                }

                override fun onHideProgress() {
                    callback.onHideProgress()
                }
            })
    }

    override fun filterByArea(
        area: String,
        callback: MealResultCallback<MealResponse<MealFilter>>
    ) {
        repository.filterByArea(
            apiKey,
            area,
            object : MealDataSource.GetRemoteCallback<MealResponse<MealFilter>> {
                override fun onSuccess(data: MealResponse<MealFilter>) {
                    callback.getResultData(data)
                }

                override fun onFailed(statusCode: Int, errorMessage: String?) {
                    callback.failedResult(statusCode, errorMessage)
                }

                override fun onShowProgress() {
                    callback.onShowProgress()
                }

                override fun onHideProgress() {
                    callback.onHideProgress()
                }

            })
    }
}