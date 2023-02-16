package com.example.lab_2_new

import android.os.Bundle
import android.util.Log
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.lab_2_new.models.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {
    private var name = arrayOf<String?>()
    private var image = arrayOf<String?>()
    private val token = "ESKV640-XY3479H-PFE0HJ9-NC6CGWK"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        movies
    }

    fun renderMovies(image: Array<String?>, name: Array<String?>) {
        val listView: ListView = findViewById(R.id.list_view)
        listView.adapter = ListAdapter(this, image, name)
    }

    private val movies: Unit
        get() {
            KinoPoiskService.getInstance()
                ?.getJSONApi()
                ?.getMovies(token, "2002", "year", "poster", "-1")
                ?.enqueue(object : Callback<MovieList?> {
                    override fun onResponse(
                        call: Call<MovieList?>,
                        response: Response<MovieList?>
                    ) {
                        assert(response.body() != null)
                        val movieList: ArrayList<Movie>? = response.body()?.docs
                        var movies: Array<Movie?> = arrayOfNulls(movieList?.size!!)
                        movies = movieList.toArray(movies)
                        name = movies
                            .map { movie -> if (movie?.name == null) movie?.alternativeName else movie.name }
                            .toTypedArray()
                        image = movies
                            .map { movie -> movie?.poster?.previewUrl }
                            .toTypedArray()

                        renderMovies(image, name)
                        Log.d("MOVIE", java.lang.String.valueOf(movies[0]))
                    }

                    override fun onFailure(call: Call<MovieList?>, t: Throwable) {
                        Log.d("ERROR", "Error occurred while getting request!")
                        t.printStackTrace()
                    }
                })
        }
}