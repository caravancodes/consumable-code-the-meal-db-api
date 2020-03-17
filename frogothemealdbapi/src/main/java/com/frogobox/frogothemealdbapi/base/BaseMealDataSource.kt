package com.frogobox.frogothemealdbapi.base

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
 * com.frogobox.frogomealsapi.base
 *
 */
interface BaseMealDataSource {

    interface ResponseCallback<T> {

        // If success fetching data from API
        fun onSuccess(data: T)

        // If failed fetching data from API
        fun onFailed(statusCode: Int, errorMessage: String? = "")

        // Show Progress View
        fun onShowProgress()

        // Hide Progress View
        fun onHideProgress()

    }

}