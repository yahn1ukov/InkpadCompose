package com.ua.inkpadcompose.navigation

import androidx.navigation.NavHostController
import com.ua.inkpadcompose.utils.Action
import com.ua.inkpadcompose.utils.Constants.LIST_SCREEN

class Screens(navController: NavHostController) {
    val list: (Action) -> Unit = { action ->
        navController.navigate("list/${action.name}") {
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }

    val note: (Int) -> Unit = { noteId ->
        navController.navigate("note/${noteId}")
    }
}