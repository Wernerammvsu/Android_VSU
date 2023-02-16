package com.example.lab3.Model

import android.util.Log
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow

object BookRepository : CRUDInterface {

    private val books = ArrayList<Book>()
    val booksList = MutableStateFlow<BooksList>(BooksList(ArrayList()))

    init {
        create(Book("Евгений Онегин", "А.С. Пушкин", 1825))
        create(Book("Анна Каренина", "Л.Н.Толстой", 1875))
        create(Book("Анна Каренина 1 часть", "Л.Н.Толстой", 1875))
        create(Book("Анна Каренина 2 часть", "Л.Н.Толстой", 1875))
        create(Book("Анна Каренина 3 часть", "Л.Н.Толстой", 1875))
        create(Book("Анна Каренина 4 часть", "Л.Н.Толстой", 1875))
        create(Book("Анна Каренина 5 часть", "Л.Н.Толстой", 1875))
        create(Book("Анна Каренина 6 часть", "Л.Н.Толстой", 1875))
        create(Book("Анна Каренина 2 сезон", "Л.Н.Толстой", 1875))
        create(Book("Анна Каренина 3 сезон", "Л.Н.Толстой", 1875))
        create(Book("Анна Каренина 4 сезон", "Л.Н.Толстой", 1875))
        create(Book("Анна Каренина 5 сезон", "Л.Н.Толстой", 1875))
        create(Book("Анна Каренина 6 сезон", "Л.Н.Толстой", 1875))
        create(Book("Анна Каренина 7 сезон", "Л.Н.Толстой", 1875))
        create(Book("Анна Каренина 8 сезон", "Л.Н.Толстой", 1875))
    }

    override fun create(book: Book) {
        var isExcite: Boolean = false
        for( book_ in books){
            if (book_ == book) {
                isExcite = true
            }}
        if (!isExcite){
            books.add(book)
        }

        booksList.tryEmit(BooksList(books))
    }

    override fun read(index: Int): Book? {
        val lastBookIndex : Int = books.lastIndex
        if ((index < 0) or (index > lastBookIndex))
            return null
        return books[index]
    }

    override fun update(index: Int, book: Book) {
        val lastBookIndex : Int = books.lastIndex
        if ((index >= 0) and (index <= lastBookIndex)){
            books[index] = book
        }

        booksList.tryEmit(BooksList(books))
    }

    override fun delete(index: Int) {
        val lastBookIndex : Int = books.lastIndex

        if ((index >= 0) && (index <= lastBookIndex)) {
            books.removeAt(index)
        }
        booksList.tryEmit(BooksList(books))
    }

    override fun readAll(): MutableList<Book> {
        return this.books
    }


    override fun equals(other: Any?): Boolean {
        if (other == null || other.javaClass != this.javaClass){
            return false
        }
        val otherBooks: BookRepository = other as BookRepository
        val thisBooksLength = this.books.size
        val otherBooksLength = otherBooks.books.size
        if (thisBooksLength != otherBooksLength) {
            return false
        }
        for (i in 0..thisBooksLength) {
            if (this.books[i] != otherBooks.books[i]){
                return false
            }
        }
        return true
    }
}

class BooksList(val books: ArrayList<Book>){

}