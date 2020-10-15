package com.abhinesh.notetaking.framework.di

import android.app.Application
import com.abhinesh.core.data.Note
import com.abhinesh.core.repository.NoteRepository
import com.abhinesh.notetaking.framework.RoomNoteDataSource
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideRepository(app: Application) = NoteRepository(RoomNoteDataSource(app))
}