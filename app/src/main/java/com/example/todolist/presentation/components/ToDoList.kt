package com.example.todolist.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.domain.model.Todo

/*Composable is used to populate the list items observed from view model */
@Composable
fun ToDoList(toDos: List<Todo>, searchText: String) {

    Box(modifier = Modifier.fillMaxSize()) {
        val filteredList = toDos.filter { it.title.contains(searchText, ignoreCase = true) }
        if (toDos.isEmpty() || filteredList.isEmpty()) {
            NoToDOItemFound(modifier = Modifier.align(Alignment.Center))
        } else {
            /*Used below code to populate the all items in list*/
            LazyColumn {
                items(toDos) { toDo ->
                    if (toDo.title.contains(searchText, ignoreCase = true)) {
                        ToDoItem(toDo)
                    }
                }
            }
        }
    }
}


