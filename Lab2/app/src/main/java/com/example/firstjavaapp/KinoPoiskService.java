package com.example.firstjavaapp;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class KinoPoiskService {
    private static KinoPoiskService mInstance;
    private static final String BASE_URL = "https://api.kinopoisk.dev";
    private final Retrofit mRetrofit;

    private KinoPoiskService() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static KinoPoiskService getInstance() {
        if (mInstance == null) {
            mInstance = new KinoPoiskService();
        }
        return mInstance;
    }

    public KinoPoiskApi getJSONApi() {
        return mRetrofit.create(KinoPoiskApi.class);
    }
}
