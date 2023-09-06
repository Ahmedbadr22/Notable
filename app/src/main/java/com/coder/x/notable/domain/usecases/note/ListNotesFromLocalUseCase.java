package com.coder.x.notable.domain.usecases.note;

import android.util.Log;

import com.coder.x.notable.data.model.NoteModel;
import com.coder.x.notable.domain.repository.NoteRepository;

import java.util.List;

import javax.inject.Inject;

public class ListNotesFromLocalUseCase {
    private final NoteRepository noteRepository;

    @Inject
    public ListNotesFromLocalUseCase(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }


    public List<NoteModel> invoke() {

        Log.i("NoteViewModel", "ListNotesFromLocalUseCase: Called");
        return noteRepository.listAllNotes();
    }
}
