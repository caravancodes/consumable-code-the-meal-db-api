# consumable-code-meal-api By AmirIsBack
- v1.0.0 - Development
- Stable Version

# About This Project
Eliminates the method of retrieving json data using retrofit repeatedly. so this project has a set of functions to retrieve data without the need for fetching data using the retrofit of the API

# Special From This Project
Simple code and reusable data

# Fecthing Data Library
- Retrofit
- RxJava
- OkHttp
- Chuck Interceptor

# Documentation Meal Api
https://www.themealdb.com/api.php

# Function Main From This Project

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


# Android Library Version (build.gradle)
- ext.kotlin_version = '1.3.70'
- classpath 'com.android.tools.build:gradle:3.6.1'
- compileSdkVersion 29
- buildToolsVersion "29.0.3"
- minSdkVersion 21

# Version Release
This Is Latest Release

    $version_release = 1.0.0

What's New??

    * Stable Version *

# How To Use This Project
<h3>Step 1. Add the JitPack repository to your build file</h3>

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  
<h3>Step 2. Add the dependency</h3>

	dependencies {
	        // library consumable code the meal db api
            implementation 'com.github.amirisback:consumable-code-the-meal-db-api:$version_release'
	}
	
<h3>Step 3. Declaration ConsumeTheMealDbApi</h3>

	val consumeMealApi = ConsumeTheMealDbApi("1") // 1 is API_KEY
    consumeMealApi.usingChuckInterceptor(this) // Using Chuck Interceptor
    consumeMealApi.listAllCateories(object : MealResultCallback<MealResponse<Category>> {
        override fun getResultData(data: MealResponse<Category>) {

            // * PLACE YOUR CODE HERE FOR UI / ARRAYLIST *

        }

        override fun failedResult(statusCode: Int, errorMessage: String?) {
            Toast.makeText(this@MainActivity, errorMessage, Toast.LENGTH_SHORT).show()
        }
    })
	
# Colaborator
Very open to anyone, I'll write your name under this, please contribute by sending an email to me

- Mail To faisalamircs@gmail.com
- Subject : Github _ [Github-Username-Account] _ [Language] _ [Repository-Name]
- Example : Github_amirisback_kotlin_admob-helper-implementation

Name Of Contribute
- Muhammad Faisal Amir
- Waiting List
- Waiting List

Waiting for your contribute

# Attention !!!
Please enjoy and don't forget fork and give a star
- Don't Forget Follow My Github Account
- If you like this library, please help me / you can donate to buy patreon services