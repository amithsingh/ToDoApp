package com.example.todolist.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Todo
import com.example.domain.usecase.TodoUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

/*ViewModel Hilt class to have interaction with view and populate the data to view*/
@HiltViewModel
class ToDoViewModel @Inject constructor(
    private val todoUseCases: TodoUseCases
) : ViewModel() {

    val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    val todos: StateFlow<List<Todo>> = todoUseCases.getTodosUseCase().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    fun addTodo(
        title: String,
    ) = viewModelScope.launch {
        try {
            todoUseCases.addTodoUseCase.invoke(Todo(title = title))
            _errorMessage.value = null
        } catch (e: Exception) {
            _errorMessage.value = e.message
        }
    }


    fun clearErrorMessage() {
        _errorMessage.value = null
    }
}