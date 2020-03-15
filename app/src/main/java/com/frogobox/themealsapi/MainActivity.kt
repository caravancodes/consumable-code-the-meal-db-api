package com.frogobox.themealsapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.frogothemealdbapi.ConsumeMealApi
import com.frogobox.frogothemealdbapi.callback.MealResultCallback
import com.frogobox.frogothemealdbapi.data.response.CategoriesList
import com.frogobox.frogothemealdbapi.data.response.Meals

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val consumeMealApi = ConsumeMealApi("1")

        consumeMealApi.usingChuckInterceptor(this)
        consumeMealApi.listAllCateories(object : MealResultCallback<CategoriesList> {
            override fun getResultData(data: CategoriesList) {
                for (i in data.meals!!.indices) {

                }
            }

            override fun failedResult(statusCode: Int, errorMessage: String?) {
                TODO("Not yet implemented")
            }
        })


    }
}
