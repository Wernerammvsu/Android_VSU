package com.example.kinopoisk_mvvm.Model

data class Film (val name: String, val author: String, val year: Int) {


    override fun equals(other: Any?): Boolean {
        if (other == null || other.javaClass != this.javaClass){
            return false
        }
        val otherFilm: Film = other as Film
        if ((otherFilm.name != this.name) || (otherFilm.author != this.author) ||
            (otherFilm.year != this.year)){
            return false
        }

        return true
    }
}