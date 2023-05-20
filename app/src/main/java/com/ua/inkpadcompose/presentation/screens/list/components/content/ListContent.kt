package com.ua.inkpadcompose.presentation.screens.list.components.content

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import com.ua.inkpadcompose.data.models.entities.NoteEntity
import com.ua.inkpadcompose.utils.RequestState

@ExperimentalMaterial3Api
@Composable
fun ListContent(
    notes: RequestState<List<NoteEntity>>,
    navigateToNoteScreen: (noteId: Int) -> Unit
) {
    if (notes is RequestState.Success) {
        if (notes.data.isEmpty()) {
            ListEmpty()
        } else {
            ListNotes(
                notes = notes.data,
                navigateToNoteScreen = navigateToNoteScreen
            )
        }
    }
}