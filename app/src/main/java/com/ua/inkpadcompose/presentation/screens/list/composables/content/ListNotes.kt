package com.ua.inkpadcompose.presentation.screens.list.composables.content

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import com.ua.inkpadcompose.data.models.entities.NoteEntity

@ExperimentalMaterial3Api
@Composable
fun ListNotes(
    notes: List<NoteEntity>,
    navigateToNoteScreen: (noteId: Int) -> Unit
) {
    LazyColumn {
        items(
            items = notes,
            key = { note -> note.id }
        ) { note ->
            ListNoteItem(
                note = note,
                navigateToNoteScreen = navigateToNoteScreen
            )
        }
    }
}