package com.example.lab3.Model

import android.util.Log
import com.example.kinopoisk_mvvm.Model.CRUD
import com.example.kinopoisk_mvvm.Model.Film
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow

object FilmRepository : CRUD {

    private val films = ArrayList<Film>()
    val filmsList = MutableStateFlow<FilmsList>(FilmsList(ArrayList()))

    init {

    }

    override fun create(film: Film) {
        var isExcite: Boolean = false
        for( film_ in films){
            if (film_ == film) {
                isExcite = true
            }}
        if (!isExcite){
            films.add(film)
        }

        filmsList.tryEmit(FilmsList(films))
    }

    override fun read(index: Int): Film? {
        val lastFilmIndex : Int = films.lastIndex
        if ((index < 0) or (index > lastFilmIndex))
            return null
        return films[index]
    }

    override fun update(index: Int, film: Film) {
        val lastFilmIndex : Int = films.lastIndex
        if ((index >= 0) and (index <= lastFilmIndex)){
            films[index] = film
        }

        filmsList.tryEmit(FilmsList(films))
    }

    override fun delete(index: Int) {
        val lastFilmIndex : Int = films.lastIndex

        if ((index >= 0) && (index <= lastFilmIndex)) {
            films.removeAt(index)
        }
        filmsList.tryEmit(FilmsList(films))
    }

    override fun readAll(): MutableList<Film> {
        return this.films
    }


    override fun equals(other: Any?): Boolean {
        if (other == null || other.javaClass != this.javaClass){
            return false
        }
        val otherFilms: FilmRepository = other as FilmRepository
        val thisFilmsLength = this.films.size
        val otherFilmsLength = otherFilms.films.size
        if (thisFilmsLength != otherFilmsLength) {
            return false
        }
        for (i in 0..thisFilmsLength) {
            if (this.films[i] != otherFilms.films[i]){
                return false
            }
        }
        return true
    }
}

class FilmsList(val films: ArrayList<Film>){

}