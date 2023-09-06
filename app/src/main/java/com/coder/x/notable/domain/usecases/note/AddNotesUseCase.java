package com.coder.x.notable.domain.usecases.note;

import com.coder.x.notable.data.model.NoteForm;
import com.coder.x.notable.data.model.NoteModel;
import com.coder.x.notable.domain.repository.NoteRepository;

import javax.inject.Inject;

public class AddNotesUseCase {
    private final NoteRepository noteRepository;

    @Inject
    public AddNotesUseCase(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }


    public NoteModel invoke(NoteForm noteForm) {
        return noteRepository.addNote(noteForm);
    }
}
