package com.example.lab3.View

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lab3.Model.Book
import com.example.lab3.ViewModel.BookViewModel



@Composable
fun MainView(viewModel: BookViewModel = viewModel()){

    var showAddDialog by remember {
        mutableStateOf(false)
    }
    var bookToEdit by remember {
        mutableStateOf(-1)
    }
    val closeAddDialog = {
        showAddDialog = false
    }
    val closeEditDialog = {
        bookToEdit = -1
    }
    fun showEditDialog(index: Int) {
        bookToEdit = index
    }

    val books by viewModel.books.collectAsState()

    if (showAddDialog) {
        BookDialog( onAdd = viewModel::add, toClose=closeAddDialog )
    }

    if (bookToEdit > -1) {
        val book = viewModel.read(bookToEdit)
        if ( book != null) {
            BookDialog(name = book.name, author = book.author, year = book.year.toString(),
                onEdit = viewModel::update, toClose = closeEditDialog, index = bookToEdit)
        }
    }


    Column {
        BookListView(books = books.books, onDelete = viewModel::delete, onEdit = {showEditDialog(it)}, modifier = Modifier.weight(1f))

        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            ElevatedButton(onClick = { showAddDialog = true }) {
                Text(text = "+")
            }
        }

    }

}

@Composable
fun BookListView(books: List<Book>, onDelete: (Int)->Unit, onEdit: (Int) -> Unit, modifier: Modifier) {
    LazyColumn (modifier) {
        books.mapIndexed{ index, book ->
            item { BookItem(book, {onDelete(index)}, {onEdit(index)}) }
        }
    }

}

@Composable
fun BookItem(book: Book, onDelete: ()->Unit, onEdit: ()->Unit){
    Row(
        modifier = Modifier.padding(16.dp)
    ) {
        Column() {
            Text(text = book.name)
            Text(text = book.author)
            Text(text = book.year.toString())
        }

        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = onEdit) {
            Icon(Icons.Filled.Edit, null)
        }
        ElevatedButton(onClick = onDelete) {
            Text(text = "X")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookDialog(name:String = "book name", author:String = "author", year:String = "year", index:Int=-1,
               onAdd: (Book)->Unit = {},
               onEdit: (Int, Book)->Unit = { _, _ ->},
               toClose: ()->Unit){

    var fieldName by remember {
        mutableStateOf(name)
    }
    var fieldAuthor by remember {
        mutableStateOf(author)
    }
    var fieldYear by remember {
        mutableStateOf(year)
    }
    Dialog(onDismissRequest = toClose) {

        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally) {

            TextField(value = fieldName, onValueChange = {fieldName = it})
            TextField(value = fieldAuthor, onValueChange = {fieldAuthor = it})
            TextField(value = fieldYear, onValueChange = {fieldYear = it})

            ElevatedButton(onClick = {

                if (fieldName != "" && fieldAuthor != "" && fieldYear.toIntOrNull() != null){
                    onAdd(Book(name=fieldName, author=fieldAuthor, year=fieldYear.toInt()))
                    onEdit(index, Book(name=fieldName, author=fieldAuthor, year=fieldYear.toInt()))
                    toClose()
                }
            }) {
                Icon(Icons.Filled.Done, null)
            }
        }

    }
}
