package com.example.lab3.Model

data class Book(val name: String, val image: String, val year: Int) {


    override fun equals(other: Any?): Boolean {
        if (other == null || other.javaClass != this.javaClass){
            return false
        }
        val otherBook: Book = other as Book
        if ((otherBook.name != this.name) || (otherBook.image != this.image) ||
            (otherBook.year != this.year)){
            return false
        }

        return true
    }
}