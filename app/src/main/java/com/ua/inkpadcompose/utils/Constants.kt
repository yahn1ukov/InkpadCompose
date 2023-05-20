package com.ua.inkpadcompose.utils

import com.ua.inkpadcompose.data.models.enums.Priority

object Constants {
    const val DATABASE_NAME = "InkpadCompose.db"
    const val NOTE_TABLE_NAME = "notes"

    const val LIST_SCREEN = "list/{action}"
    const val NOTE_SCREEN = "note/{noteId}"

    const val LIST_ARGUMENT_KEY = "action"
    const val NOTE_ARGUMENT_KEY = "noteId"

    val PRIORITIES_FILTER = listOf(Priority.LOW, Priority.HIGH, Priority.NONE)

    val PRIORITIES_DROP_DOWN = listOf(Priority.HIGH, Priority.MEDIUM, Priority.LOW)
}