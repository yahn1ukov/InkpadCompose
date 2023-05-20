package com.ua.inkpadcompose.data.repositories

import com.ua.inkpadcompose.data.dao.NoteDao
import com.ua.inkpadcompose.data.models.entities.NoteEntity
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class NoteRepository @Inject constructor(private val noteDao: NoteDao) {
    fun getAll(): Flow<List<NoteEntity>> {
        return noteDao.getAll()
    }

    fun get(noteId: Int): Flow<NoteEntity> {
        return noteDao.get(noteId)
    }

    suspend fun insert(note: NoteEntity) {
        noteDao.insert(note)
    }

    suspend fun update(note: NoteEntity) {
        noteDao.update(note)
    }

    suspend fun delete(note: NoteEntity) {
        noteDao.delete(note)
    }

    suspend fun deleteAll() {
        noteDao.deleteAll()
    }

    fun search(query: String): Flow<List<NoteEntity>> {
        return noteDao.search(query)
    }

    fun sortByLowPriority(): Flow<List<NoteEntity>> {
        return noteDao.sortByLowPriority()
    }

    fun sortByHighPriority(): Flow<List<NoteEntity>> {
        return noteDao.sortByHighPriority()
    }
}