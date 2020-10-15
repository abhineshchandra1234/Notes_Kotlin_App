package com.abhinesh.notetaking.framework

import com.abhinesh.core.usecase.*

class UseCases (
    val addNote: AddNote,
    val getAllNotes: GetAllNotes,
    val getNote: GetNote,
    val removeNote: RemoveNote,
    val getWordCount: GetWordCount
)