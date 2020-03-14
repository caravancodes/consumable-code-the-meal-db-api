package com.frogobox.frogomealsapi

import android.content.Context
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
class ConsumeMealApi (private val apiKey: String) : ConsumeMealApiView {

    private val repository = MealRepository(MealRemoteDataSource)

    override fun usingChuckInterceptor(context: Context) {
        repository.usingChuckInterceptor(context)
    }

}