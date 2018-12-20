package com.example.kathishan.startwarmovies.film

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.apisample.BASE_URL_ISS
import com.example.apisample.R
import com.example.kathishan.startwarmovies.BASE_URL
import com.example.kathishan.startwarmovies.R
import kotlinx.android.synthetic.main.activity_film.*
import kotlinx.android.synthetic.main.activity_iss.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FilmActivity : AppCompatActivity() {

    private val adapter = FilmAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film)

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient
            .Builder()
            .addInterceptor(loggingInterceptor)
            .build()


        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

        val retrofit = retrofitBuilder
            .client(okHttpClient)
            .build()

        val filmClient = retrofit.create(FilmService::class.java)

        rvPasses.layoutManager = LinearLayoutManager(this)
        rvPasses.adapter = adapter

                    override fun onResponse(call: Call<FilmResult>, result: Response<FilmResult>) {
                        if (result.isSuccessful) {
                            adapter.setData(result.body()?.title?: emptyList())
                        }
                    }

    }

}

