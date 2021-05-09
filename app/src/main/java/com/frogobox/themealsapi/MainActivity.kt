package com.frogobox.themealsapi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.frogobox.frogolog.FLog
import com.frogobox.frogothemealdbapi.ConsumeTheMealDbApi
import com.frogobox.frogothemealdbapi.callback.MealResultCallback
import com.frogobox.frogothemealdbapi.data.model.Meal
import com.frogobox.frogothemealdbapi.data.response.MealResponse
import com.frogobox.recycler.core.IFrogoViewAdapter
import com.frogobox.themealsapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        setupConsumableMealApi("b")
    }

    private fun consumeMealApi(): ConsumeTheMealDbApi {
        val consumeCode = ConsumeTheMealDbApi("1")
        consumeCode.usingChuckInterceptor(this)
        return consumeCode
    }

    private fun setupConsumableMealApi(firstLetter: String) {
        binding.apply {
            consumeMealApi().listAllMeal(
                firstLetter,
                object : MealResultCallback<MealResponse<Meal>> {
                    override fun getResultData(data: MealResponse<Meal>) {
                        data.meals?.let { setupFrogoRecyclerView(it) }
                    }

                    override fun failedResult(statusCode: Int, errorMessage: String?) {
                        Toast.makeText(this@MainActivity, errorMessage, Toast.LENGTH_SHORT).show()
                    }

                    override fun onShowProgress() {
                        // Show Your Progress View
                        runOnUiThread {
                            progressBar.visibility = View.VISIBLE
                        }
                    }

                    override fun onHideProgress() {
                        // Hide Your Progress View
                        runOnUiThread {
                            progressBar.visibility = View.GONE
                        }
                    }
                })
        }
    }

    private fun setupFrogoRecyclerView(data: List<Meal>) {
        binding.frogoRv.injector<Meal>()
            .addData(data)
            .addCustomView(R.layout.frogo_rv_grid_type_2)
            .addCallback(object : IFrogoViewAdapter<Meal> {
                override fun onItemClicked(data: Meal) {
                    FLog.d(data.strMeal, this@MainActivity)
                }

                override fun onItemLongClicked(data: Meal) {

                }

                override fun setupInitComponent(view: View, data: Meal) {
                    val ivPoster = view.findViewById<ImageView>(R.id.frogo_rv_grid_type_2_iv_poster)
                    val tvTitle = view.findViewById<TextView>(R.id.frogo_rv_grid_type_2_tv_title)
                    val tvSubTitle = view.findViewById<TextView>(R.id.frogo_rv_grid_type_2_tv_subtitle)

                    Glide.with(view.context).load(data.strMealThumb).into(ivPoster)
                    tvTitle.text = data.strMeal
                    tvSubTitle.text = data.strCategory
                }
            })
            .createLayoutGrid(2)
            .build()
    }

}
