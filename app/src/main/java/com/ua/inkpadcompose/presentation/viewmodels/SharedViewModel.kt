package com.ua.inkpadcompose.presentation.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ua.inkpadcompose.data.models.entities.NoteEntity
import com.ua.inkpadcompose.data.models.enums.Priority
import com.ua.inkpadcompose.data.repositories.NoteRepository
import com.ua.inkpadcompose.utils.RequestState
import com.ua.inkpadcompose.utils.SearchAppBarState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val noteRepository: NoteRepository
) : ViewModel() {
    val id = mutableStateOf(0)
    val title = mutableStateOf("")
    val priority = mutableStateOf(Priority.LOW)
    val description = mutableStateOf("")

    val searchAppBarState = mutableStateOf(SearchAppBarState.CLOSED)
    val searchTextState = mutableStateOf("")

    private val _notes = MutableStateFlow<RequestState<List<NoteEntity>>>(RequestState.Idle)
    val notes: StateFlow<RequestState<List<NoteEntity>>>
        get() = _notes

    private val _selectedNote = MutableStateFlow<NoteEntity?>(null)
    val selectedNote: StateFlow<NoteEntity?>
        get() = _selectedNote

    fun getAll() {
        _notes.value = RequestState.Loading
        try {
            viewModelScope.launch {
                noteRepository.getAll().collect {
                    _notes.value = RequestState.Success(it)
                }
            }
        } catch (e: Exception) {
            _notes.value = RequestState.Error(e)
        }
    }

    fun get(noteId: Int) {
        viewModelScope.launch {
            noteRepository.get(noteId).collect {
                _selectedNote.value = it
            }
        }
    }

    fun updateFields(note: NoteEntity?) {
        if (note != null) {
            id.value = note.id
            title.value = note.title
            priority.value = note.priority
            description.value = note.description
        } else {
            id.value = 0
            title.value = ""
            priority.value = Priority.LOW
            description.value = ""
        }
    }
}