package com.ua.inkpadcompose.di

import android.content.Context
import androidx.room.Room
import com.ua.inkpadcompose.data.dao.NoteDao
import com.ua.inkpadcompose.data.database.InkpadComposeDatabase
import com.ua.inkpadcompose.utils.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideInkpadComposeDatabase(@ApplicationContext context: Context): InkpadComposeDatabase {
        return Room.databaseBuilder(
            context,
            InkpadComposeDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun provideNoteDao(database: InkpadComposeDatabase): NoteDao {
        return database.noteDao()
    }
}