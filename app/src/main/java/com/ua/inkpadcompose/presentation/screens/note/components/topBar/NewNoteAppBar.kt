package com.ua.inkpadcompose.presentation.screens.note.components.topBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.ua.inkpadcompose.R
import com.ua.inkpadcompose.utils.Action

@ExperimentalMaterial3Api
@Composable
fun NewNoteAppBar(
    onBackClicked: (Action) -> Unit,
    onAddClicked: (Action) -> Unit
) {
    TopAppBar(
        navigationIcon = {
            BackAction(
                onBackClicked = onBackClicked
            )
        },
        title = {
            Text(text = stringResource(id = R.string.new_note_screen_title))
        },
        actions = {
            AddAction(
                onAddClicked = onAddClicked
            )
        }
    )
}

@Composable
private fun BackAction(
    onBackClicked: (Action) -> Unit
) {
    IconButton(onClick = {
        onBackClicked(Action.NO_ACTION)
    }) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = stringResource(id = R.string.back_action)
        )
    }
}

@Composable
private fun AddAction(
    onAddClicked: (Action) -> Unit
) {
    IconButton(onClick = {
        onAddClicked(Action.ADD)
    }) {
        Icon(
            imageVector = Icons.Default.Check,
            contentDescription = stringResource(id = R.string.add_action)
        )
    }
}