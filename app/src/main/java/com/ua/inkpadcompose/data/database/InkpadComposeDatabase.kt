package com.ua.inkpadcompose.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ua.inkpadcompose.data.dao.NoteDao
import com.ua.inkpadcompose.data.models.entities.NoteEntity
import com.ua.inkpadcompose.data.models.typeconverters.PriorityConverter

@Database(entities = [NoteEntity::class], version = 1, exportSchema = false)
@TypeConverters(PriorityConverter::class)
abstract class InkpadComposeDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}