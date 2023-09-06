package com.coder.x.notable.data.source.local.note;

import com.coder.x.notable.data.model.NoteForm;
import com.coder.x.notable.data.model.NoteModel;

import java.util.List;

public interface NoteLocalDataSource {

    long addNote(NoteForm noteForm);
    NoteModel getNoteById(long id);
    List<NoteModel> listAllNotes();

    boolean deleteNoteById(long id);
    boolean editNote(NoteModel noteModel);
}
