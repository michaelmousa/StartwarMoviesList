package com.example.kathishan.startwarmovies.film


import android.view.ViewDebug
import com.example.kathishan.startwarmovies.FILMS_ENDPOINT
import com.example.kathishan.startwarmovies.FilmService
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FilmService {

    @GET(FILMS_ENDPOINT)
    fun getFilmService(@Query("title") toString: String): Call<FilmResult>

}