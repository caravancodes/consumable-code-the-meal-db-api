package com.frogobox.frogothemealdbapi.data.source

import android.content.Context
import com.frogobox.frogothemealdbapi.data.model.*
import com.frogobox.frogothemealdbapi.data.response.*
import com.frogobox.frogothemealdbapi.util.MealConstant
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

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
object MealRemoteDataSource : MealDataSource {

    private val mealApiService = MealApiService

    override fun usingChuckInterceptor(context: Context) {
        mealApiService.usingChuckInterceptor(context)
    }

    override fun searchMeal(
        apiKey: String,
        mealName: String,
        callback: MealDataSource.GetRemoteCallback<MealResponse<Meal>>
    ) {
        mealApiService.getApiService
            .searchMeal(apiKey, mealName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : MealApiCallback<MealResponse<Meal>>() {
                override fun onSuccess(data: MealResponse<Meal>) {
                    callback.onSuccess(data)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                override fun onFinish() {
                }
            })

    }

    override fun listAllMeal(
        apiKey: String,
        firstLetter: String,
        callback: MealDataSource.GetRemoteCallback<MealResponse<Meal>>
    ) {
        mealApiService.getApiService
            .listAllMeal(apiKey, firstLetter)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : MealApiCallback<MealResponse<Meal>>() {
                override fun onSuccess(data: MealResponse<Meal>) {
                    callback.onSuccess(data)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                override fun onFinish() {
                }
            })
    }

    override fun lookupFullMeal(
        apiKey: String,
        idMeal: String,
        callback: MealDataSource.GetRemoteCallback<MealResponse<Meal>>
    ) {
        mealApiService.getApiService
            .lookupFullMeal(apiKey, idMeal)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : MealApiCallback<MealResponse<Meal>>() {
                override fun onSuccess(data: MealResponse<Meal>) {
                    callback.onSuccess(data)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                override fun onFinish() {
                }
            })
    }

    override fun lookupRandomMeal(
        apiKey: String,
        callback: MealDataSource.GetRemoteCallback<MealResponse<Meal>>
    ) {
        mealApiService.getApiService
            .lookupRandomMeal(apiKey)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : MealApiCallback<MealResponse<Meal>>() {
                override fun onSuccess(data: MealResponse<Meal>) {
                    callback.onSuccess(data)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                override fun onFinish() {
                }
            })
    }

    override fun listMealCategories(
        apiKey: String,
        callback: MealDataSource.GetRemoteCallback<CategoryResponse>
    ) {
        mealApiService.getApiService
            .listMealCategories(apiKey)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : MealApiCallback<CategoryResponse>() {
                override fun onSuccess(data: CategoryResponse) {
                    callback.onSuccess(data)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                override fun onFinish() {
                }
            })
    }

    override fun listAllCateories(
        apiKey: String,
        callback: MealDataSource.GetRemoteCallback<MealResponse<Category>>
    ) {
        mealApiService.getApiService
            .listAllCateories(apiKey, MealConstant.VALUE_LIST)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : MealApiCallback<MealResponse<Category>>() {
                override fun onSuccess(data: MealResponse<Category>) {
                    callback.onSuccess(data)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                override fun onFinish() {
                }
            })
    }

    override fun listAllArea(
        apiKey: String,
        callback: MealDataSource.GetRemoteCallback<MealResponse<Area>>
    ) {
        mealApiService.getApiService
            .listAllArea(apiKey, MealConstant.VALUE_LIST)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : MealApiCallback<MealResponse<Area>>() {
                override fun onSuccess(data: MealResponse<Area>) {
                    callback.onSuccess(data)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                override fun onFinish() {
                }
            })
    }

    override fun listAllIngredients(
        apiKey: String,
        callback: MealDataSource.GetRemoteCallback<MealResponse<Ingredient>>
    ) {
        mealApiService.getApiService
            .listAllIngredients(apiKey, MealConstant.VALUE_LIST)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : MealApiCallback<MealResponse<Ingredient>>() {
                override fun onSuccess(data: MealResponse<Ingredient>) {
                    callback.onSuccess(data)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                override fun onFinish() {
                }
            })
    }

    override fun filterByIngredient(
        apiKey: String,
        ingredient: String,
        callback: MealDataSource.GetRemoteCallback<MealResponse<MealFilter>>
    ) {
        mealApiService.getApiService
            .filterByIngredient(apiKey, ingredient)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : MealApiCallback<MealResponse<MealFilter>>() {
                override fun onSuccess(data: MealResponse<MealFilter>) {
                    callback.onSuccess(data)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                override fun onFinish() {
                }
            })
    }
}