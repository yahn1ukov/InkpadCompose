package com.ua.inkpadcompose.presentation.screens.note

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.ua.inkpadcompose.data.models.entities.NoteEntity
import com.ua.inkpadcompose.presentation.screens.note.components.content.NoteContent
import com.ua.inkpadcompose.presentation.screens.note.components.topBar.NoteAppBar
import com.ua.inkpadcompose.presentation.theme.LARGE_PADDING
import com.ua.inkpadcompose.presentation.viewmodels.SharedViewModel
import com.ua.inkpadcompose.utils.Action

@ExperimentalMaterial3Api
@Composable
fun NoteScreen(
    selectedNote: NoteEntity?,
    navigateToListScreen: (Action) -> Unit,
    sharedViewModel: SharedViewModel
) {
    val title by sharedViewModel.title
    val priority by sharedViewModel.priority
    val description by sharedViewModel.description

    Scaffold(
        topBar = {
            NoteAppBar(
                selectedNote = selectedNote,
                navigateToListScreen = navigateToListScreen
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = LARGE_PADDING)
            ) {
                NoteContent(
                    title = title,
                    onTitleChanged = { title ->
                        sharedViewModel.title.value = title
                    },
                    priority = priority,
                    onPrioritySelected = { priority ->
                        sharedViewModel.priority.value = priority
                    },
                    description = description,
                    onDescriptionChanged = { description ->
                        sharedViewModel.description.value = description
                    }
                )
            }
        },
    )
}