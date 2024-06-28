package com.example.domain.usecase

import com.example.domain.model.Todo
import com.example.domain.repo.TodoRepository
import javax.inject.Inject

class AddTodoUseCase @Inject constructor(
    private val repository: TodoRepository
) {
    suspend operator fun invoke(todo: Todo) = repository.addToDo(todo)
}