package com.example.lab_2_new


import com.example.lab_2_new.models.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface KinoPoiskApi {
    @GET("/movie")
    fun getMovies(
        @Query("token") token: String?,
        @Query("search") search: String?,
        @Query("field") field: String?,
        @Query("sortField") sortField: String?,
        @Query("sortType") sortType: String?
    ): Call<MovieList?>?
}