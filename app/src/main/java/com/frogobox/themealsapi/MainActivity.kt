package com.frogobox.themealsapi

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.frogothemealdbapi.ConsumeTheMealDbApi
import com.frogobox.frogothemealdbapi.callback.MealResultCallback
import com.frogobox.frogothemealdbapi.data.model.Category
import com.frogobox.frogothemealdbapi.data.response.MealResponse

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val consumeMealApi = ConsumeTheMealDbApi("1")

        consumeMealApi.usingChuckInterceptor(this)
        consumeMealApi.listAllCateories(object : MealResultCallback<MealResponse<Category>> {
            override fun getResultData(data: MealResponse<Category>) {
                for (i in data.meals!!.indices) {
                    Toast.makeText(this@MainActivity, data.meals!![i].strCategory, Toast.LENGTH_SHORT).show()
                }
            }

            override fun failedResult(statusCode: Int, errorMessage: String?) {
                Toast.makeText(this@MainActivity, errorMessage, Toast.LENGTH_SHORT).show()
            }
        })


    }
}
