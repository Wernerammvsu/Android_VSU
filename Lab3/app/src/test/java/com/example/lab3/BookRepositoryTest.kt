package com.example.lab3

import com.example.lab3.Model.Book
import com.example.lab3.Model.BookRepository
import junit.framework.Assert.assertEquals
import org.junit.Test

internal class BookRepositoryTest {
    private val book1: Book = Book("Евгений Онегин", "А.С. Пушкин", 1825)
    private val book2: Book = Book("Анна Каренина", "Л.Н.Толстой", 1875)
    private val expectedBooks = mutableListOf(book1, book2)
    private val expectedBook2 = mutableListOf(book2)

    @Test
    fun create_differentBooks_Success() {
        val booksR = BookRepository()
        booksR.create(book1)
        booksR.create(book2)
        val actualBooks = booksR.books
        assertEquals(expectedBooks, actualBooks)
    }

    @Test
    fun create_existedBooks_Fail() {
        val booksR = BookRepository()
        booksR.create(book1)
        booksR.create(book2)
        booksR.create(book1)
        val actualBooks = booksR.books
        assertEquals(expectedBooks, actualBooks)
    }

    @Test
    fun read_existedIndex_Success() {
        val booksR = BookRepository()
        booksR.books = mutableListOf(book1, book2)
        val actualBook = booksR.read(0)
        assertEquals(book1, actualBook)
    }

    @Test
    fun read_invalidIndex_Fail() {
        val booksR = BookRepository()
        booksR.books = mutableListOf(book1, book2)
        val actualBook = booksR.read(3)
        assertEquals(null, actualBook)
    }

    @Test
    fun update_existedBook_Success() {
        val booksR = BookRepository()
        booksR.books = mutableListOf(book1)
        booksR.update(0, book2)
        val actualBooks = booksR.books
        assertEquals(expectedBook2, actualBooks)
    }

    @Test
    fun update_nonExistedBook_Fail() {
        val booksR = BookRepository()
        booksR.books = mutableListOf(book2)
        booksR.update(1, book2)
        val actualBooks = booksR.books
        assertEquals(expectedBook2, actualBooks)
    }

    @Test
    fun delete_existedBook_Success() {
        val booksR = BookRepository()
        booksR.books = mutableListOf(book1, book2)
        booksR.delete(0)
        val actualBooks = booksR.books
        assertEquals(expectedBook2, actualBooks)
    }

    @Test
    fun deleteNegative_nonExistedBook_Fail() {
        val booksR = BookRepository()
        booksR.books = mutableListOf(book1, book2)
        booksR.delete(5)
        val actualBooks = booksR.books
        assertEquals(expectedBooks, actualBooks)
    }

    @Test
    fun readAll_Success() {
        val booksR = BookRepository()
        booksR.books = mutableListOf(book1, book2)
        val actualBooks = booksR.readAll()
        assertEquals(expectedBooks, actualBooks)
    }
}