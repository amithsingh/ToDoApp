package com.example.todolist.presentation.components

import android.annotation.SuppressLint
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.todolist.R
import com.example.todolist.presentation.viewmodel.ToDoViewModel

/*Main Screen component to show the top bar with floating action button and search filter*/
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDoListScreen(navController: NavHostController, toDoViewModel: ToDoViewModel) {
    val toDos by toDoViewModel.todos.collectAsState(emptyList())
    var searchText by rememberSaveable { mutableStateOf("") }
    val context = LocalContext.current as? ComponentActivity ?: return
    val statusBarColor = colorResource(id = R.color.statusColor)

    val errorMessage by toDoViewModel.errorMessage.collectAsState()

    SideEffect {
        context.window.statusBarColor = statusBarColor.toArgb()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.to_do_list), color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp)
                            .wrapContentHeight(align = Alignment.CenterVertically)
                    )
                },
                modifier = Modifier
                    .height(50.dp),

                colors = TopAppBarDefaults.topAppBarColors(containerColor = colorResource(id = R.color.green))

            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("addToDo") },
                contentColor = colorResource(id = R.color.green),
                elevation = FloatingActionButtonDefaults.elevation()
            ) {
                Icon(Icons.Default.Add, contentDescription = stringResource(id = R.string.add_todo))
            }
        }, content = {
            /*Used below view the show search filter*/
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
            ) {
                OutlinedTextField(
                    value = searchText,
                    onValueChange = { searchText = it },
                    singleLine = true,
                    placeholder = { Text(stringResource(id = R.string.search_for_todo)) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .height(50.dp)
                )

                /*Added the condition to show success and failure action */
                errorMessage?.let { _ ->
                    ShowErrorAlert(toDoViewModel)
                }
                ToDoList(toDos = toDos, searchText)
            }
        }
    )
}



