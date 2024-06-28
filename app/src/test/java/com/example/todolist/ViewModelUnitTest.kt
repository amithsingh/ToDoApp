package com.example.todolist


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.domain.model.Todo
import com.example.domain.usecase.TodoUseCases
import com.example.todolist.presentation.viewmodel.ToDoViewModel
import io.mockk.Runs
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.just
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
@ExperimentalCoroutinesApi
class ViewModelUnitTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = StandardTestDispatcher()
    private lateinit var todoUseCases: TodoUseCases
    private lateinit var viewModel: ToDoViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        todoUseCases = mockk(relaxed = true)
        viewModel = ToDoViewModel(todoUseCases)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    /*Unit test case for getToDo list from flow and execute the getTodosUseCase and get appropriate results*/
    @Test
    fun `todos flow getToItemList`() = runTest {
        // Arrange
        val todos = listOf(Todo(id = 1, title = "ToDo Item 1"))
        val todosFlow = MutableStateFlow(todos)
        every { todoUseCases.getTodosUseCase() } returns todosFlow

        // Create a new ViewModel instance to initialize the todos flow
        viewModel = ToDoViewModel(todoUseCases)
        testDispatcher.scheduler.advanceUntilIdle()
        // Act & Assert
        val emittedValues = mutableListOf<List<Todo>>()
        val job = launch(testDispatcher) {
            viewModel.todos.collectLatest { value ->
                emittedValues.add(value)
            }
        }
        testDispatcher.scheduler.advanceUntilIdle()
        // Verify
        assertEquals(todos, emittedValues.last())
        job.cancel()
    }

    /*Unit test case for adding TodoItem to list of flow and execute the addTodoUseCase and get appropriate results*/
    @Test
    fun `addToDo success`() = runTest {
        val todo = Todo(title = "New Todo")
        coEvery { todoUseCases.addTodoUseCase.invoke(todo) } just Runs

        // Act
        viewModel.addTodo(todo.title)

        testDispatcher.scheduler.advanceUntilIdle()

        // Assert
        assertNull(viewModel.errorMessage.value)
        coVerify { todoUseCases.addTodoUseCase.invoke(todo) }
    }

    /*Unit test case to check failure while adding TodoItem to list of flow*/
    @Test
    fun `addTodo failure`() = runTest {
        // Arrange
        val todo = Todo(title = "New Todo")
        val errorMessage = "Error adding todo"
        coEvery { todoUseCases.addTodoUseCase.invoke(todo) } throws Exception(errorMessage)

        // Act
        viewModel.addTodo(todo.title)

        testDispatcher.scheduler.advanceUntilIdle()

        // Assert
        assertEquals(errorMessage, viewModel.errorMessage.value)
        coVerify { todoUseCases.addTodoUseCase.invoke(todo) }
    }

    /*Unit test case for check clear error message if added any message to the error message variable*/
    @Test
    fun clearErrorMessage() {
        // Arrange
        viewModel._errorMessage.value = "Some error"

        // Act
        viewModel.clearErrorMessage()

        // Assert
        assertNull(viewModel.errorMessage.value)
    }

}