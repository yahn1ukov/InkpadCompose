package com.ua.inkpadcompose.data.models.typeconverters

import androidx.room.TypeConverter
import com.ua.inkpadcompose.data.models.enums.Priority

class PriorityConverter {
    @TypeConverter
    fun fromPriorityToString(priority: Priority): String {
        return priority.name
    }

    @TypeConverter
    fun fromStringToPriority(priority: String): Priority {
        return Priority.valueOf(priority)
    }
}