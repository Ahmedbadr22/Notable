package com.coder.x.notable.domain.usecases.note;

import android.util.Log;

import com.coder.x.notable.data.model.NoteForm;
import com.coder.x.notable.domain.di.NoteRepository;

import javax.inject.Inject;

public class AddNotesUseCase {
    private final NoteRepository noteRepository;

    @Inject
    public AddNotesUseCase(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }


    public void invoke(NoteForm noteForm) {
        noteRepository.addNote(noteForm);
        Log.i("NoteViewModel", "AddNotesUseCase: Called");
    }
}
