package com.example.todolist.presentation.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.todolist.R
import com.example.todolist.presentation.viewmodel.ToDoViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/*This component is used for Adding TODOList item to the screen*/
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddToDoScreen(navController: NavHostController, toDoViewModel: ToDoViewModel) {

    var toDoTitle by rememberSaveable { mutableStateOf("") }
    var showProgress by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }


    Scaffold(modifier = Modifier.fillMaxSize(),
        snackbarHost = { SnackbarHost(snackBarHostState) },
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.add_todo), color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp)
                            .wrapContentHeight(align = Alignment.CenterVertically)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = stringResource(id = R.string.back),
                            tint = Color.White
                        )
                    }
                },
                modifier = Modifier
                    .height(50.dp),

                colors = TopAppBarDefaults.topAppBarColors(containerColor = colorResource(id = R.color.green))

            )
        },
        content = {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
            ) {
                OutlinedTextField(
                    value = toDoTitle,
                    onValueChange = { toDoTitle = it },
                    label = { Text(stringResource(id = R.string.enter_new_item)) },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))

                /*Added condition to show the snack bar if user try to click of Add button without entering the TODOOutline text*/
                Button(
                    onClick = {

                        showProgress = true
                        coroutineScope.launch {
                            delay(3000) // Hides the progress indicator after 3 seconds
                            showProgress = false
                            if (toDoTitle.isNotEmpty()) {
                                toDoViewModel.addTodo(title = toDoTitle)
                                navController.popBackStack()
                            } else {

                                snackBarHostState.showSnackbar(
                                    message = "Enter new item field should not be empty!",
                                    actionLabel = "Ok",
                                    duration = SnackbarDuration.Short
                                )
                            }

                        }

                    },
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.green)),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(end = 16.dp)
                ) {
                    Text(text = stringResource(id = R.string.add_todo))
                }

                /*Showing Progress bar based on condition for 3 seconds*/
                if (showProgress) {
                    Spacer(modifier = Modifier.height(16.dp))
                    CircularProgressIndicator(
                        color = colorResource(id = R.color.green),
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }

            }
        }
    )
}


