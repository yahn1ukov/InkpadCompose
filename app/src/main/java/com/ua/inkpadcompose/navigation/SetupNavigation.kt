package com.ua.inkpadcompose.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.ua.inkpadcompose.navigation.destinations.listComposable
import com.ua.inkpadcompose.navigation.destinations.noteComposable
import com.ua.inkpadcompose.presentation.viewmodels.SharedViewModel
import com.ua.inkpadcompose.utils.Constants.LIST_SCREEN

@ExperimentalMaterial3Api
@Composable
fun SetupNavigation(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    val screens = remember(navController) {
        Screens(navController = navController)
    }

    NavHost(
        navController = navController,
        startDestination = LIST_SCREEN
    ) {
        listComposable(
            navigateToNoteScreen = screens.note,
            sharedViewModel = sharedViewModel
        )
        noteComposable(
            navigateToListScreen = screens.list
        )
    }
}