package com.example.kinopoisk_mvvm.Model

interface CRUD {
    fun create(film: Film)

    fun read(index: Int): Film?

    fun readAll():MutableList<Film>

    fun update(index: Int, film: Film)

    fun delete(index: Int)

}