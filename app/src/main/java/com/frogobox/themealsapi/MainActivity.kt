package com.frogobox.themealsapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.frogothemealdbapi.ConsumeMealApi
import com.frogobox.frogothemealdbapi.callback.MealResultCallback
import com.frogobox.frogothemealdbapi.data.model.Category
import com.frogobox.frogothemealdbapi.data.response.MealResponse

class MainActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val consumeMealApi = ConsumeMealApi("1")

        consumeMealApi.usingChuckInterceptor(this)
        consumeMealApi.listAllCateories(object : MealResultCallback<MealResponse<Category>> {
            override fun getResultData(data: MealResponse<Category>) {
                for (i in data.meals!!.indices) {

                }
            }

            override fun failedResult(statusCode: Int, errorMessage: String?) {
                TODO("Not yet implemented")
            }
        })


    }
}
