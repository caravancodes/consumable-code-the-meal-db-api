package com.frogobox.frogomealsapi.data.source

import android.content.Context
import com.frogobox.frogomealsapi.base.BaseMealDataSource

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


    // Response Callback
    interface GetRemoteCallback<T> : BaseMealDataSource.ResponseCallback<T>

}