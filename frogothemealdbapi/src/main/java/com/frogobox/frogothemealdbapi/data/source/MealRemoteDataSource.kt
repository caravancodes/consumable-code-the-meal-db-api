package com.frogobox.frogothemealdbapi.data.source

import android.content.Context
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
        callback: MealDataSource.GetRemoteCallback<Meals>
    ) {
        mealApiService.getApiService
            .searchMeal(apiKey, mealName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : MealApiCallback<Meals>() {
                override fun onSuccess(data: Meals) {
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
        callback: MealDataSource.GetRemoteCallback<Meals>
    ) {
        mealApiService.getApiService
            .listAllMeal(apiKey, firstLetter)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : MealApiCallback<Meals>() {
                override fun onSuccess(data: Meals) {
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
        callback: MealDataSource.GetRemoteCallback<Meals>
    ) {
        mealApiService.getApiService
            .lookupFullMeal(apiKey, idMeal)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : MealApiCallback<Meals>() {
                override fun onSuccess(data: Meals) {
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
        callback: MealDataSource.GetRemoteCallback<Meals>
    ) {
        mealApiService.getApiService
            .lookupRandomMeal(apiKey)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : MealApiCallback<Meals>() {
                override fun onSuccess(data: Meals) {
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
        callback: MealDataSource.GetRemoteCallback<Categories>
    ) {
        mealApiService.getApiService
            .listMealCategories(apiKey)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : MealApiCallback<Categories>() {
                override fun onSuccess(data: Categories) {
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
        callback: MealDataSource.GetRemoteCallback<CategoriesList>
    ) {
        mealApiService.getApiService
            .listAllCateories(apiKey, MealConstant.VALUE_LIST)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : MealApiCallback<CategoriesList>() {
                override fun onSuccess(data: CategoriesList) {
                    callback.onSuccess(data)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                override fun onFinish() {
                }
            })
    }

    override fun listAllArea(apiKey: String, callback: MealDataSource.GetRemoteCallback<Areas>) {
        mealApiService.getApiService
            .listAllArea(apiKey, MealConstant.VALUE_LIST)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : MealApiCallback<Areas>() {
                override fun onSuccess(data: Areas) {
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
        callback: MealDataSource.GetRemoteCallback<Ingredients>
    ) {
        mealApiService.getApiService
            .listAllIngredients(apiKey, MealConstant.VALUE_LIST)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : MealApiCallback<Ingredients>() {
                override fun onSuccess(data: Ingredients) {
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