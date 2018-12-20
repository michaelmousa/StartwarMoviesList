package com.example.kathishan.startwarmovies

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FilmService {
    @GET("{title}")
    fun getTilteDetails(@Path("title") titleName: String): Call<FilmUser>
}