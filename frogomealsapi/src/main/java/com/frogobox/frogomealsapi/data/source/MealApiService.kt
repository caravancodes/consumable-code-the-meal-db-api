package com.frogobox.frogomealsapi.data.source

import android.content.Context
import com.frogobox.frogomealsapi.data.response.Meals
import com.frogobox.frogomealsapi.util.MealConstant
import com.frogobox.frogomealsapi.util.MealUrl
import com.readystatesoftware.chuck.ChuckInterceptor
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

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
interface MealApiService {

    // Search meal by name
    @GET(MealUrl.MEALDB_URL_SEARCH_MEAL)
    fun searchMeal(
        @Path(MealConstant.PATH_API_KEY) apiKey: String,
        @Query(MealConstant.QUERY_NAME) nameMeal: String
    ): Observable<Meals>

    // List all meals by first letter
    @GET(MealUrl.MEALDB_URL_SEARCH_MEAL)
    fun listAllMeal(
        @Path(MealConstant.PATH_API_KEY) apiKey: String,
        @Query(MealConstant.QUERY_FIRST_LETTER) firstLetter: String
    ): Observable<Meals>

    // Lookup full meal details by id
    @GET(MealUrl.MEALDB_URL_LOOKUP_MEAL)
    fun lookupFullMeal(
        @Path(MealConstant.PATH_API_KEY) apiKey: String,
        @Query(MealConstant.QUERY_ID) idMeal: String
    ): Observable<Meals>

    // Lookup a single random meal
    @GET(MealUrl.MEALDB_URL_RANDOM_MEAL)
    fun lookupRandomMeal(
        @Path(MealConstant.PATH_API_KEY) apiKey: String
    ): Observable<Meals>

    companion object Factory {

        private var isUsingChuckInterceptor = false
        private lateinit var context: Context

        fun usingChuckInterceptor(context: Context) {
            isUsingChuckInterceptor = true
            this.context = context
        }

        val getApiService: MealApiService by lazy {
            val mLoggingInterceptor = HttpLoggingInterceptor()
            mLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            val mClient = if (isUsingChuckInterceptor) {
                OkHttpClient.Builder()
                    .addInterceptor(mLoggingInterceptor)
                    .addInterceptor(ChuckInterceptor(context))
                    .readTimeout(30, TimeUnit.SECONDS)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .build()
            } else {
                OkHttpClient.Builder()
                    .readTimeout(30, TimeUnit.SECONDS)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .build()
            }

            val mRetrofit = Retrofit.Builder()
                .baseUrl(MealUrl.MEALDB_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(mClient)
                .build()

            mRetrofit.create(MealApiService::class.java)
        }
    }

}