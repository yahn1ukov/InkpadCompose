package com.ua.inkpadcompose.presentation.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ua.inkpadcompose.R
import com.ua.inkpadcompose.data.models.enums.Priority
import com.ua.inkpadcompose.presentation.theme.DROP_DOWN__HEIGHT
import com.ua.inkpadcompose.presentation.theme.PRIORITY_INDICATOR_SIZE
import com.ua.inkpadcompose.utils.Constants.PRIORITIES_DROP_DOWN

@Composable
fun PriorityDropDown(
    priority: Priority,
    onPrioritySelected: (Priority) -> Unit
) {
    var expended by remember { mutableStateOf(false) }
    val dropDownIconAngel by animateFloatAsState(
        targetValue = if (expended) 180f else 0f
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.background)
            .height(DROP_DOWN__HEIGHT)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onSurface,
                shape = MaterialTheme.shapes.small
            )
            .clickable { expended = true },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Canvas(
            modifier = Modifier
                .size(PRIORITY_INDICATOR_SIZE)
                .weight(1f),
            onDraw = {
                drawCircle(
                    color = priority.color
                )
            }
        )
        Text(
            modifier = Modifier
                .weight(8f),
            text = priority.name
        )
        IconButton(
            modifier = Modifier
                .rotate(dropDownIconAngel)
                .weight(1.5f),
            onClick = { expended = true }
        ) {
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = stringResource(id = R.string.drop_down_button)
            )
        }
        DropdownMenu(
            modifier = Modifier
                .fillMaxWidth(fraction = 0.94f)
                .background(color = MaterialTheme.colorScheme.background),
            expanded = expended,
            onDismissRequest = { expended = false }
        ) {
            for (p in PRIORITIES_DROP_DOWN) {
                DropdownMenuItem(
                    leadingIcon = {
                        Canvas(
                            modifier = Modifier
                                .size(PRIORITY_INDICATOR_SIZE),
                            onDraw = {
                                drawCircle(
                                    color = p.color
                                )
                            }
                        )
                    },
                    text = {
                        Text(text = p.name)
                    },
                    onClick = {
                        expended = false
                        onPrioritySelected(p)
                    }
                )
            }
        }
    }
}