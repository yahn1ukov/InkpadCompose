package com.ua.inkpadcompose.presentation.screens.list.components.topBar

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.ua.inkpadcompose.R
import com.ua.inkpadcompose.data.models.enums.Priority
import com.ua.inkpadcompose.presentation.theme.PRIORITY_INDICATOR_SIZE
import com.ua.inkpadcompose.utils.Constants

@ExperimentalMaterial3Api
@Composable
fun DefaultListAppBar(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit,
    onDeleteAllClicked: () -> Unit
) {
    TopAppBar(
        title = {
            Text(text = stringResource(id = R.string.list_screen_title))
        },
        actions = {
            SearchAction(
                onSearchClicked = onSearchClicked
            )
            SortAction(
                onSortClicked = onSortClicked
            )
            DeleteAllAction(
                onDeleteAllClicked = onDeleteAllClicked
            )
        }
    )
}

@Composable
private fun SearchAction(
    onSearchClicked: () -> Unit
) {
    IconButton(onClick = { onSearchClicked() }) {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = stringResource(id = R.string.search_action)
        )
    }
}

@Composable
private fun SortAction(
    onSortClicked: (Priority) -> Unit
) {
    var expended by remember { mutableStateOf(false) }

    IconButton(onClick = { expended = true }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_filter),
            contentDescription = stringResource(id = R.string.sort_action)
        )
        DropdownMenu(
            expanded = expended,
            onDismissRequest = { expended = false }
        ) {
            for (priority in Constants.PRIORITIES_FILTER) {
                DropdownMenuItem(
                    text = {
                        Text(text = priority.name)
                    },
                    leadingIcon = {
                        Canvas(
                            modifier = Modifier.size(PRIORITY_INDICATOR_SIZE),
                            onDraw = {
                                drawCircle(color = priority.color)
                            }
                        )
                    },
                    onClick = {
                        expended = false
                        onSortClicked(priority)
                    }
                )
            }
        }
    }
}

@Composable
private fun DeleteAllAction(
    onDeleteAllClicked: () -> Unit
) {
    var expended by remember { mutableStateOf(false) }

    IconButton(onClick = { expended = true }) {
        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = stringResource(id = R.string.delete_all_action)
        )
        DropdownMenu(
            expanded = expended,
            onDismissRequest = { expended = false }
        ) {
            DropdownMenuItem(
                text = {
                    Text(
                        text = stringResource(id = R.string.delete_all_action),
                        color = Color.Red
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = stringResource(id = R.string.delete_all_action),
                        tint = Color.Red
                    )
                },
                onClick = {
                    expended = false
                    onDeleteAllClicked()
                }
            )
        }
    }
}