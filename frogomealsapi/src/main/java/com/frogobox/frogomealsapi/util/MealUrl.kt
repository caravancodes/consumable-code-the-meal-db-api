package com.frogobox.frogomealsapi.util

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
 * com.frogobox.frogomealsapi.util
 *
 */
class MealUrl {

    companion object {

        const val MEAL_BASE_URL = "https://www.themealdb.com/"
        const val MEAL_BASE_PATH = "api/json/v1/"
        const val PATH_API = "api/json/v1/{api_key}/"
        const val MEAL_SEARCH = "$MEAL_BASE_PATH$PATH_API" + "search.php"

    }


}