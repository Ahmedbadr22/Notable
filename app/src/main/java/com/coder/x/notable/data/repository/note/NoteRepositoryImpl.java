package com.coder.x.notable.data.repository.note;

import com.coder.x.notable.data.model.NoteForm;
import com.coder.x.notable.data.model.NoteModel;
import com.coder.x.notable.data.source.local.note.NoteLocalDataSource;
import com.coder.x.notable.domain.repository.NoteRepository;

import java.util.List;

import javax.inject.Inject;

public class NoteRepositoryImpl implements NoteRepository {

    private final NoteLocalDataSource noteLocalDataSource;

    @Inject
    public NoteRepositoryImpl(NoteLocalDataSource noteLocalDataSource) {
        this.noteLocalDataSource = noteLocalDataSource;
    }


    @Override
    public NoteModel addNote(NoteForm noteForm) {
        long id = noteLocalDataSource.addNote(noteForm);
        NoteModel noteModel = getNoteById(id);
        return noteModel;
    }

    @Override
    public NoteModel getNoteById(long id) {
        return noteLocalDataSource.getNoteById(id);
    }

    @Override
    public List<NoteModel> listAllNotes() {
        return noteLocalDataSource.listAllNotes();
    }

    @Override
    public boolean deleteNoteById(long id) {
        return noteLocalDataSource.deleteNoteById(id);
    }

    @Override
    public boolean editNote(NoteModel noteModel) {
        return noteLocalDataSource.editNote(noteModel);
    }
}
