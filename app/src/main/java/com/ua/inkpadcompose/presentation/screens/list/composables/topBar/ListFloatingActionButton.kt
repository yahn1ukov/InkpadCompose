package com.ua.inkpadcompose.presentation.screens.list.composables.topBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.ua.inkpadcompose.R

@Composable
fun ListFloatingActionButton(
    onFABClicked: (Int) -> Unit
) {
    FloatingActionButton(
        onClick = { onFABClicked(-1) }
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = stringResource(id = R.string.add_button)
        )
    }
}