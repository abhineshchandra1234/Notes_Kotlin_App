package com.abhinesh.core.usecase

import com.abhinesh.core.data.Note
import com.abhinesh.core.repository.NoteRepository

class RemoveNote(private val noteRepository: NoteRepository) {
    suspend operator fun invoke(note: Note) = noteRepository.removeNote(note)
}