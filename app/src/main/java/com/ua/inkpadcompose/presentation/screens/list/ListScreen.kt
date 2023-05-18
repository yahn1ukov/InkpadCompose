package com.ua.inkpadcompose.presentation.screens.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.ua.inkpadcompose.presentation.screens.list.composables.ListAppBar
import com.ua.inkpadcompose.presentation.screens.list.composables.ListFloatingActionButton
import com.ua.inkpadcompose.presentation.viewmodels.SharedViewModel
import com.ua.inkpadcompose.utils.SearchAppBarState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    navigateToNoteScreen: (Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    val searchAppBarState: SearchAppBarState
            by sharedViewModel.searchAppBarState
    val searchTextState: String by sharedViewModel.searchTextState

    Scaffold(
        topBar = {
            ListAppBar(
                sharedViewModel = sharedViewModel,
                searchAppBarState = searchAppBarState,
                searchTextState = searchTextState
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
            ) {}
        },
        floatingActionButton = {
            ListFloatingActionButton(onFABClicked = navigateToNoteScreen)
        }
    )
}