package com.example.todolist.presentation.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import com.example.todolist.R
import com.example.todolist.presentation.viewmodel.ToDoViewModel

/*Composable function is used to show error popup if any failure while adding item to to list*/
@Composable
fun ShowErrorAlert(toDoViewModel: ToDoViewModel) {
    AlertDialog(
        onDismissRequest = { toDoViewModel.clearErrorMessage() },
        title = { Text(stringResource(id = R.string.error)) },
        text = { Text(stringResource(id = R.string.failed_to_add_todo)) },
        confirmButton = {
            Button(
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.green)),
                onClick = { toDoViewModel.clearErrorMessage() }) {
                Text(stringResource(id = R.string.dismiss))
            }

        }
    )
}