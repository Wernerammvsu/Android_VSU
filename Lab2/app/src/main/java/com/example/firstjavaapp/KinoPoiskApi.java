package com.example.firstjavaapp;

import com.example.firstjavaapp.models.Image;
import com.example.firstjavaapp.models.Movie;
import com.example.firstjavaapp.models.MovieList;
import com.example.firstjavaapp.models.Person;
import com.example.firstjavaapp.models.Review;
import com.example.firstjavaapp.models.Season;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface KinoPoiskApi {
    @GET("/movie")
    Call<Movie> getMovie(@Query("token") String token, @Query("search") String search, @Query("field") String field);

    @GET("/movie")
    Call<MovieList> getMovies(@Query("token") String token, @Query("search") String search, @Query("field") String field, @Query("sortField") String sortField, @Query("sortType") String sortType);

    @GET("/person")
    Call<Person> getPerson(@Query("token") String token, @Query("search") String search, @Query("field") String field);

    @GET("/review")
    Call<Review> getReview(@Query("token") String token, @Query("search") String search, @Query("field") String field);

    @GET("/image")
    Call<Image> getImage(@Query("token") String token, @Query("search") String search, @Query("field") String field);

    @GET("/season")
    Call<Season> getSeason(@Query("token") String token, @Query("search") String search, @Query("field") String field);
}
