package com.ua.inkpadcompose.presentation.screens.note.components.topBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import com.ua.inkpadcompose.R
import com.ua.inkpadcompose.data.models.entities.NoteEntity
import com.ua.inkpadcompose.utils.Action

@ExperimentalMaterial3Api
@Composable
fun ExistingNoteAppBar(
    selectedNote: NoteEntity,
    onCloseClicked: (Action) -> Unit,
    onDeleteClicked: (Action) -> Unit,
    onUpdateClicked: (Action) -> Unit
) {
    TopAppBar(
        navigationIcon = {
            CloseAction(
                onCloseClicked = onCloseClicked
            )
        },
        title = {
            Text(
                text = selectedNote.title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        actions = {
            DeleteAction(
                onDeleteClicked = onDeleteClicked
            )
            UpdateAction(
                onUpdateClicked = onUpdateClicked
            )
        }
    )
}

@Composable
private fun CloseAction(
    onCloseClicked: (Action) -> Unit
) {
    IconButton(onClick = {
        onCloseClicked(Action.NO_ACTION)
    }) {
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = stringResource(id = R.string.close_action)
        )
    }
}

@Composable
private fun DeleteAction(
    onDeleteClicked: (Action) -> Unit
) {
    IconButton(onClick = {
        onDeleteClicked(Action.DELETE)
    }) {
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = stringResource(id = R.string.delete_action)
        )
    }
}

@Composable
private fun UpdateAction(
    onUpdateClicked: (Action) -> Unit
) {
    IconButton(onClick = {
        onUpdateClicked(Action.UPDATE)
    }) {
        Icon(
            imageVector = Icons.Default.Check,
            contentDescription = stringResource(id = R.string.update_action)
        )
    }
}