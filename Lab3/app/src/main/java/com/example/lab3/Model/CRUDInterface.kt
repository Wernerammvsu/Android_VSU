package com.example.lab3.Model

interface CRUDInterface {
    fun create(book: Book)

    fun read(index: Int): Book?

    fun readAll():MutableList<Book>

    fun update(index: Int, book: Book)

    fun delete(index: Int)

}