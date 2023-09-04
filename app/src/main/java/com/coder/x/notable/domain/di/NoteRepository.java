package com.coder.x.notable.domain.di;

import androidx.lifecycle.LiveData;

import com.coder.x.notable.data.model.NoteForm;
import com.coder.x.notable.data.model.NoteModel;

import java.util.List;

public interface NoteRepository {

    NoteModel addNote(NoteForm noteForm);
    NoteModel getNoteById(long id);
    List<NoteModel> listAllNotes();
}
