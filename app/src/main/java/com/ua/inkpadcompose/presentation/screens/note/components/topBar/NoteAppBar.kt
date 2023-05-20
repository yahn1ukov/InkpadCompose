package com.ua.inkpadcompose.presentation.screens.note.components.topBar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import com.ua.inkpadcompose.data.models.entities.NoteEntity
import com.ua.inkpadcompose.utils.Action

@ExperimentalMaterial3Api
@Composable
fun NoteAppBar(
    selectedNote: NoteEntity?,
    navigateToListScreen: (Action) -> Unit
) {
    if (selectedNote == null) {
        NewNoteAppBar(
            onBackClicked = navigateToListScreen,
            onAddClicked = navigateToListScreen
        )
    } else {
        ExistingNoteAppBar(
            selectedNote = selectedNote,
            onCloseClicked = navigateToListScreen,
            onDeleteClicked = navigateToListScreen,
            onUpdateClicked = navigateToListScreen
        )
    }
}