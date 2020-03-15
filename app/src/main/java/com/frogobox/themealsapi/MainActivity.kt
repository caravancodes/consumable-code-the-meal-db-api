package com.frogobox.themealsapi

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.frogomealsapi.ConsumeMealApi
import com.frogobox.frogomealsapi.callback.MealResultCallback
import com.frogobox.frogomealsapi.data.response.Meals

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val consumeMealApi = ConsumeMealApi("1")

        consumeMealApi.usingChuckInterceptor(this)
        consumeMealApi.lookupRandomMeal(object : MealResultCallback<Meals> {
            override fun getResultData(data: Meals) {
                for (i in data.meals!!.indices) {

                }
            }

            override fun failedResult(statusCode: Int, errorMessage: String?) {
                TODO("Not yet implemented")
            }
        })


    }
}
