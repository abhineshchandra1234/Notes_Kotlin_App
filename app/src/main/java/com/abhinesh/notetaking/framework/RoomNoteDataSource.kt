package com.abhinesh.notetaking.framework

import android.content.Context
import com.abhinesh.core.data.Note
import com.abhinesh.core.repository.NoteDataSource
import com.abhinesh.notetaking.framework.db.DatabaseService
import com.abhinesh.notetaking.framework.db.NoteEntity

class RoomNoteDataSource(context: Context): NoteDataSource {
    val noteDao = DatabaseService.getInstance(context).noteDao()

    override suspend fun add(note: Note) = noteDao.addNoteEntity(NoteEntity.fromNote(note))

    override suspend fun get(id: Long) = noteDao.getNoteEntity(id)?.toNote()

    override suspend fun getAll() = noteDao.getAllNoteEntities().map { it.toNote() }

    override suspend fun remove(note: Note) = noteDao.deleteNoteEntity(NoteEntity.fromNote(note))
}