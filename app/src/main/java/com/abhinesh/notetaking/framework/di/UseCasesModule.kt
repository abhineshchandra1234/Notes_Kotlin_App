package com.abhinesh.notetaking.framework.di

import com.abhinesh.core.repository.NoteRepository
import com.abhinesh.core.usecase.*
import com.abhinesh.notetaking.framework.UseCases
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {
    @Provides
    fun getUseCases(repository: NoteRepository) = UseCases(
                    AddNote(repository),
                    GetAllNotes(repository),
                    GetNote(repository),
                    RemoveNote(repository),
                    GetWordCount()
    )
}