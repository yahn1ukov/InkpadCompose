package com.ua.inkpadcompose.utils

import androidx.compose.ui.unit.dp
import com.ua.inkpadcompose.data.models.enums.Priority

object Constants {
    const val DATABASE_NAME = "InkpadCompose.db"
    const val NOTE_TABLE_NAME = "notes"

    const val LIST_SCREEN = "list/{action}"
    const val NOTE_SCREEN = "note/{noteId}"

    const val LIST_ARGUMENT_KEY = "action"
    const val NOTE_ARGUMENT_KEY = "noteId"

    val PRIORITIES_FILTER = listOf(Priority.LOW, Priority.HIGH, Priority.NONE)

    val TOP_APP_BAR_HEIGHT = 64.dp

    val NOTE_ITEM_ELEVATION = 2.dp
}