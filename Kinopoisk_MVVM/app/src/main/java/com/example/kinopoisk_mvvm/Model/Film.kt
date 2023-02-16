package com.example.kinopoisk_mvvm.Model

data class Film (val name: String, val author: String, val year: Int) {


    override fun equals(other: Any?): Boolean {
        if (other == null || other.javaClass != this.javaClass){
            return false
        }
        val otherBook: Film = other as Film
        if ((otherBook.name != this.name) || (otherBook.author != this.author) ||
            (otherBook.year != this.year)){
            return false
        }

        return true
    }
}