package com.example.firstjavaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import com.example.firstjavaapp.models.Image;
import com.example.firstjavaapp.models.Movie;
import com.example.firstjavaapp.models.MovieList;
import com.example.firstjavaapp.models.Person;
import com.example.firstjavaapp.models.Review;
import com.example.firstjavaapp.models.Season;
import java.util.ArrayList;
import java.util.Arrays;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    private String[] name = {

    };
    private String[] image = {

    };

    public final String token = "ESKV640-XY3479H-PFE0HJ9-NC6CGWK";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getMovies();
    //  printPerson();
    //  printReview();
    //  printImage();
    //  printSeason();
    }

    public void renderMovies(String[] image, String[] name) {
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(new ListAdapter(this, image, name));
    }
    public void getMovies() {
        KinoPoiskService.getInstance()
                .getJSONApi()
                .getMovies(token, "2020", "year", "poster", "-1")
                .enqueue(new Callback<MovieList>() {
                    @Override
                    public void onResponse(@NonNull Call<MovieList> call, @NonNull Response<MovieList> response) {
                        assert response.body() != null;
                        ArrayList<Movie> movieList = response.body().docs;
                        Movie[] movies = new Movie[movieList.size()];
                        movies = movieList.toArray(movies);
                        name = Arrays.stream(movies)
                                .map(movie -> movie.name == null ? movie.alternativeName : movie.name)
                                .toArray(String[]::new);
                        image = Arrays.stream(movies)
                                .map(movie -> movie.poster.previewUrl)
                                .toArray(String[]::new);
                        renderMovies(image, name);
                        Log.d("MOVIE", String.valueOf(movies[0]));
                    }




                    @Override
                    public void onFailure(@NonNull Call<MovieList> call, @NonNull Throwable t) {

                        Log.d("ERROR", "Error occurred while getting request!");
                        t.printStackTrace();
                    }
                });
    }
    public void printPerson() {
        KinoPoiskService.getInstance()
                .getJSONApi()
                .getPerson(token, "605", "id")
                .enqueue(new Callback<Person>() {
                    @Override
                    public void onResponse(@NonNull Call<Person> call, @NonNull Response<Person> response) {
                        Person person = response.body();
                        Log.d("PERSON", String.valueOf(person));
                    }

                    @Override
                    public void onFailure(@NonNull Call<Person> call, @NonNull Throwable t) {

                        Log.d("ERROR","Error occurred while getting request!");
                        t.printStackTrace();
                    }
                });
    }

    public void getImages(Movie[] movies) {
        for (int i = 0; i < movies.length; i++) {
            Movie movie = movies[i];
            int finalI = i;
            KinoPoiskService.getInstance()
                    .getJSONApi()
                    .getImage(token, String.valueOf(movie.id), "movieId")
                    .enqueue(new Callback<Image>() {
                        @Override
                        public void onResponse(@NonNull Call<Image> call, @NonNull Response<Image> response) {
                            assert response.body() != null;
                            Log.d("movieId", String.valueOf(movie.id));
                            if (finalI == image.length - 1) {
                                renderMovies(image, name);
                            }
                            Log.d("IMAGE", Arrays.toString(image));
                        }

                        @Override
                        public void onFailure(@NonNull Call<Image> call, @NonNull Throwable t) {

                            Log.d("ERROR","Error occurred while getting request!");
                            t.printStackTrace();
                        }
                    });
        }
    }

    public void printReview() {
        KinoPoiskService.getInstance()
                .getJSONApi()
                .getReview(token, "326", "movieId")
                .enqueue(new Callback<Review>() {
                    @Override
                    public void onResponse(@NonNull Call<Review> call, @NonNull Response<Review> response) {
                        Review review = response.body();
                        Log.d("REVIEW", String.valueOf(review));
                    }

                    @Override
                    public void onFailure(@NonNull Call<Review> call, @NonNull Throwable t) {

                        Log.d("ERROR","Error occurred while getting request!");
                        t.printStackTrace();
                    }
                });
    }

    public void printSeason() {
        KinoPoiskService.getInstance()
                .getJSONApi()
                .getSeason(token, "1253633", "movieId")
                .enqueue(new Callback<Season>() {
                    @Override
                    public void onResponse(@NonNull Call<Season> call, @NonNull Response<Season> response) {
                        Season season = response.body();
                        Log.d("SEASON", String.valueOf(season));
                    }

                    @Override
                    public void onFailure(@NonNull Call<Season> call, @NonNull Throwable t) {

                        Log.d("ERROR","Error occurred while getting request!");
                        t.printStackTrace();
                    }
                });
    }
}