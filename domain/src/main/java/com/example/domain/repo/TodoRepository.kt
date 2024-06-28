package com.example.domain.repo

import com.example.domain.model.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {
    fun getToDoList(): Flow<List<Todo>>
    suspend fun addToDo(todo:Todo)

}