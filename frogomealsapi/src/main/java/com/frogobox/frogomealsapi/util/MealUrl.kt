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

        const val MEALDB_BASE_URL = "https://www.themealdb.com/"
        const val MEALDB_BASE_PATH = "api/json/v1/"
        const val MEALDB_PATH_API = "{api_key}/"
        const val MEALDB_URL_SEARCH_MEAL = "$MEALDB_BASE_PATH$MEALDB_PATH_API" + "search.php"
        const val MEALDB_URL_LOOKUP_MEAL = "$MEALDB_BASE_PATH$MEALDB_PATH_API" + "lookup.php"
        const val MEALDB_URL_RANDOM_MEAL = "$MEALDB_BASE_PATH$MEALDB_PATH_API" + "random.php"

    }


}