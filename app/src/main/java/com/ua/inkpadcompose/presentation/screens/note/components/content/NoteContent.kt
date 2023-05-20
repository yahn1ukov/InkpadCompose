package com.ua.inkpadcompose.presentation.screens.note.components.content

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.ua.inkpadcompose.R
import com.ua.inkpadcompose.data.models.enums.Priority
import com.ua.inkpadcompose.presentation.components.PriorityDropDown
import com.ua.inkpadcompose.presentation.theme.MEDIUM_PADDING

@ExperimentalMaterial3Api
@Composable
fun NoteContent(
    title: String,
    onTitleChanged: (String) -> Unit,
    priority: Priority,
    onPrioritySelected: (Priority) -> Unit,
    description: String,
    onDescriptionChanged: (String) -> Unit,
) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = title,
        onValueChange = {
            onTitleChanged(it)
        },
        label = {
            Text(text = stringResource(id = R.string.title_label))
        },
        singleLine = true
    )
    Divider(
        modifier = Modifier
            .height(MEDIUM_PADDING),
        color = MaterialTheme.colorScheme.background
    )
    PriorityDropDown(
        priority = priority,
        onPrioritySelected = onPrioritySelected
    )
    OutlinedTextField(
        modifier = Modifier
            .fillMaxSize(),
        value = description,
        onValueChange = {
            onDescriptionChanged(it)
        },
        label = {
            Text(text = stringResource(id = R.string.title_label))
        }
    )
}