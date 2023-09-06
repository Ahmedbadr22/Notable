package com.coder.x.notable.domain.repository;

import com.coder.x.notable.data.model.NoteForm;
import com.coder.x.notable.data.model.NoteModel;

import java.util.List;

public interface NoteRepository {

    NoteModel addNote(NoteForm noteForm);
    NoteModel getNoteById(long id);
    List<NoteModel> listAllNotes();
    boolean deleteNoteById(long id);
    boolean editNote(NoteModel noteModel);
}
