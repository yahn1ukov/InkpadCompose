package com.ua.inkpadcompose.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.ua.inkpadcompose.presentation.screens.list.ListScreen
import com.ua.inkpadcompose.presentation.viewmodels.SharedViewModel
import com.ua.inkpadcompose.utils.Constants.LIST_ARGUMENT_KEY
import com.ua.inkpadcompose.utils.Constants.LIST_SCREEN

fun NavGraphBuilder.listComposable(
    navigateToNoteScreen: (Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY) {
            type = NavType.StringType
        })
    ) {
        ListScreen(
            navigateToNoteScreen = navigateToNoteScreen,
            sharedViewModel = sharedViewModel
        )
    }
}