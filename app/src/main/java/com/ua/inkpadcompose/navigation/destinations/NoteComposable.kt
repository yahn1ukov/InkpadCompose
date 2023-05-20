package com.ua.inkpadcompose.navigation.destinations

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.ua.inkpadcompose.presentation.screens.note.NoteScreen
import com.ua.inkpadcompose.presentation.viewmodels.SharedViewModel
import com.ua.inkpadcompose.utils.Action
import com.ua.inkpadcompose.utils.Constants.NOTE_ARGUMENT_KEY
import com.ua.inkpadcompose.utils.Constants.NOTE_SCREEN

@ExperimentalMaterial3Api
fun NavGraphBuilder.noteComposable(
    navigateToListScreen: (Action) -> Unit,
    sharedViewModel: SharedViewModel
) {
    composable(
        route = NOTE_SCREEN,
        arguments = listOf(navArgument(NOTE_ARGUMENT_KEY) {
            type = NavType.IntType
        })
    ) { navBackStackEntry ->
        val noteId = navBackStackEntry.arguments!!.getInt(NOTE_ARGUMENT_KEY)
        sharedViewModel.get(noteId)
        val selectedNote by sharedViewModel.selectedNote.collectAsState()

        LaunchedEffect(key1 = true) {
            sharedViewModel.updateFields(selectedNote)
        }

        NoteScreen(
            selectedNote = selectedNote,
            navigateToListScreen = navigateToListScreen,
            sharedViewModel = sharedViewModel
        )
    }
}