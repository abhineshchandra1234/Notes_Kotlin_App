package com.abhinesh.notetaking.framework.di

import com.abhinesh.notetaking.framework.ListViewModel
import com.abhinesh.notetaking.framework.NoteViewModel
import dagger.Component

@Component(modules = [ApplicationModule::class, RepositoryModule::class, UseCasesModule::class])
interface ViewModelComponent {
    fun inject(noteViewModel: NoteViewModel)
    fun inject(listViewModel: ListViewModel)

}