package com.abhinesh.notetaking.framework

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.abhinesh.core.data.Note
import com.abhinesh.core.repository.NoteRepository
import com.abhinesh.core.usecase.AddNote
import com.abhinesh.core.usecase.GetAllNotes
import com.abhinesh.core.usecase.GetNote
import com.abhinesh.core.usecase.RemoveNote
import com.abhinesh.notetaking.framework.di.ApplicationModule
import com.abhinesh.notetaking.framework.di.DaggerViewModelComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListViewModel(application: Application): AndroidViewModel(application) {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    @Inject
    lateinit var useCases: UseCases

    init {
        DaggerViewModelComponent.builder()
                .applicationModule(ApplicationModule(getApplication()))
                .build()
                .inject(this)
    }

    val notes = MutableLiveData<List<Note>>()

    fun getNotes() {
        coroutineScope.launch {
            val noteList = useCases.getAllNotes()
            noteList.forEach{it.wordCount = useCases.getWordCount.invoke(it)}
            notes.postValue(noteList)

        }
    }
}