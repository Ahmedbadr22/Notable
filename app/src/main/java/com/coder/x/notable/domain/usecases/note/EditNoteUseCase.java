package com.coder.x.notable.domain.usecases.note;

import com.coder.x.notable.data.model.NoteModel;
import com.coder.x.notable.domain.repository.NoteRepository;

import javax.inject.Inject;

public class EditNoteUseCase {
    private final NoteRepository noteRepository;

    @Inject
    public EditNoteUseCase(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }


    public boolean invoke(NoteModel noteModel) {
        return noteRepository.editNote(noteModel);
    }
}
