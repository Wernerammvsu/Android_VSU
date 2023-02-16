package com.example.lab3.ViewModel
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab3.Model.Book
import com.example.lab3.Model.BookRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach

class BookViewModel(): ViewModel() {

    private val repository: BookRepository = BookRepository
    val books = repository.booksList

    fun add(book: Book){
        repository.create(book)
    }

    fun update(index: Int, book: Book){
        repository.update(index, book)
    }

    fun delete(index: Int){
        repository.delete(index)
    }

    fun readAll(): MutableList<Book>{
        return repository.readAll()
    }

    fun read(index: Int): Book? {
        return repository.read(index)
    }

}