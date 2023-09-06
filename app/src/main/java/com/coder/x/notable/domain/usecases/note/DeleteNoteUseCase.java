package com.coder.x.notable.domain.usecases.note;


import com.coder.x.notable.domain.repository.NoteRepository;

import javax.inject.Inject;

public class DeleteNoteUseCase {
    private final NoteRepository noteRepository;

    @Inject
    public DeleteNoteUseCase(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }


    public boolean invoke(long id) {
        return noteRepository.deleteNoteById(id);
    }
}
