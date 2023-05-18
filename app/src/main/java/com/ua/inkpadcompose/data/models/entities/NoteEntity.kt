package com.ua.inkpadcompose.data.models.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ua.inkpadcompose.data.models.enums.Priority
import com.ua.inkpadcompose.utils.Constants.NOTE_TABLE_NAME

@Entity(tableName = NOTE_TABLE_NAME)
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val priority: Priority
)