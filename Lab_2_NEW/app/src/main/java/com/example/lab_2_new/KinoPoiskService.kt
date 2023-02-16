package com.example.lab_2_new

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class KinoPoiskService {

    private val BASE_URL = "https://api.kinopoisk.dev"
    private var mRetrofit: Retrofit? = null

    init {
        mRetrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    companion object{
        private var mInstance: KinoPoiskService? = null
        fun getInstance(): KinoPoiskService? {
            if (mInstance == null) mInstance = KinoPoiskService()
            return mInstance
        }
    }

    fun getJSONApi(): KinoPoiskApi? {
        return mRetrofit!!.create(KinoPoiskApi::class.java)
    }
}