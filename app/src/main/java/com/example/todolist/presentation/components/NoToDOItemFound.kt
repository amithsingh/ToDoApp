package com.example.todolist.presentation.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.todolist.R

/*Composable is used to show not items view on list item screen*/
@Composable
fun NoToDOItemFound(modifier: Modifier) {
    Text(
        text = stringResource(id = R.string.press_button_to_add),
        style = MaterialTheme.typography.bodyMedium,
        modifier = modifier,
    )
}