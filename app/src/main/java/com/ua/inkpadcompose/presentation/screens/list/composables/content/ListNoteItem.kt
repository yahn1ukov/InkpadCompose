package com.ua.inkpadcompose.presentation.screens.list.composables.content

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import com.ua.inkpadcompose.data.models.entities.NoteEntity
import com.ua.inkpadcompose.presentation.theme.LARGE_PADDING
import com.ua.inkpadcompose.presentation.theme.PRIORITY_INDICATOR_SIZE
import com.ua.inkpadcompose.utils.Constants.NOTE_ITEM_ELEVATION

@ExperimentalMaterial3Api
@Composable
fun ListNoteItem(
    note: NoteEntity,
    navigateToNoteScreen: (noteId: Int) -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RectangleShape,
        shadowElevation = NOTE_ITEM_ELEVATION,
        onClick = { navigateToNoteScreen(note.id) }
    ) {
        Column(
            modifier = Modifier
                .padding(all = LARGE_PADDING)
                .fillMaxWidth()
        ) {
            Row {
                Text(
                    modifier = Modifier
                        .weight(8f),
                    text = note.title,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    contentAlignment = Alignment.TopEnd
                ) {
                    Canvas(
                        modifier = Modifier
                            .size(PRIORITY_INDICATOR_SIZE),
                        onDraw = { drawCircle(color = note.priority.color) }
                    )
                }
            }
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = note.description,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}