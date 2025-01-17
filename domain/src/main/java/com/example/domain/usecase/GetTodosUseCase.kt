package com.example.domain.usecase

import com.example.domain.model.Todo
import com.example.domain.repo.TodoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTodosUseCase @Inject constructor(
    private val repository: TodoRepository
) {
    operator fun invoke(): Flow<List<Todo>> = repository.getToDoList()
}