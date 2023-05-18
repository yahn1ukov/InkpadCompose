package com.ua.inkpadcompose.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.ua.inkpadcompose.utils.Action
import com.ua.inkpadcompose.utils.Constants.NOTE_ARGUMENT_KEY
import com.ua.inkpadcompose.utils.Constants.NOTE_SCREEN

fun NavGraphBuilder.noteComposable(
    navigateToListScreen: (Action) -> Unit
) {
    composable(
        route = NOTE_SCREEN,
        arguments = listOf(navArgument(NOTE_ARGUMENT_KEY) {
            type = NavType.IntType
        })
    ) {}
}