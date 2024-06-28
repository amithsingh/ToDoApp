package com.example.todolist.presentation.components

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todolist.presentation.viewmodel.ToDoViewModel

@Composable
fun NavGraph() {

    val navController = rememberNavController()
    val sharedViewModel: ToDoViewModel = hiltViewModel()

    NavHost(navController, startDestination = "toDoList") {
        composable("toDoList") {
            ToDoListScreen(navController = navController, toDoViewModel = sharedViewModel)
        }
        composable("addToDo") {
            AddToDoScreen(navController = navController, toDoViewModel = sharedViewModel)
        }
    }
}