package com.example.data.repository

import com.example.data.local.ToDoDAO
import com.example.data.local.ToDoEntity
import com.example.domain.model.Todo
import com.example.domain.repo.TodoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TodoRepositoryImpl @Inject constructor(private val todoDao: ToDoDAO) :
    TodoRepository {

    override fun getToDoList(): Flow<List<Todo>> {
        return todoDao.getToDoList().map { entities ->
            entities.map { it.toDomain() }
        }
    }
    override suspend fun addToDo(todo: Todo) {
        todoDao.addToDo(ToDoEntity.fromDomain(todo))
    }
}