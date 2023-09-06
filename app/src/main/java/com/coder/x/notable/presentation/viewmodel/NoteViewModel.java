package com.coder.x.notable.presentation.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.coder.x.notable.app.uitls.Utils;
import com.coder.x.notable.data.model.NoteForm;
import com.coder.x.notable.data.model.NoteModel;
import com.coder.x.notable.domain.usecases.note.AddNotesUseCase;
import com.coder.x.notable.domain.usecases.note.DeleteNoteUseCase;
import com.coder.x.notable.domain.usecases.note.EditNoteUseCase;
import com.coder.x.notable.domain.usecases.note.ListNotesFromLocalUseCase;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class NoteViewModel extends ViewModel {

    private final AddNotesUseCase addNotesUseCase;
    private final DeleteNoteUseCase deleteNoteUseCase;
    private final EditNoteUseCase editNoteUseCase;

    public MutableLiveData<List<NoteModel>> notesLiveDate = new MutableLiveData<>(new ArrayList<>());


    @Inject
    public NoteViewModel(
            ListNotesFromLocalUseCase listNotesFromLocalUseCase,
            AddNotesUseCase addNotesUseCase,
            DeleteNoteUseCase deleteNoteUseCase,
            EditNoteUseCase editNoteUseCase
    ) {
        this.addNotesUseCase = addNotesUseCase;
        this.deleteNoteUseCase = deleteNoteUseCase;
        this.editNoteUseCase = editNoteUseCase;
        List<NoteModel> notes = listNotesFromLocalUseCase.invoke();
        notesLiveDate.setValue(notes);
    }


    public void addNote(String title, String body) {
        NoteForm noteForm = new NoteForm(title.trim(), body.trim());

        NoteModel addedNoteModel = addNotesUseCase.invoke(noteForm);
        List<NoteModel> notes = notesLiveDate.getValue();
        assert notes != null;
        notes.add(addedNoteModel);
        notesLiveDate.setValue(notes);
    }

    public boolean deleteNote(long id) {
        boolean isDeleted = deleteNoteUseCase.invoke(id);
        if (isDeleted) {
            List<NoteModel> updatedNotes = new ArrayList<>();
            for(int i = 0; i < notesLiveDate.getValue().size(); i++) {
                NoteModel note = notesLiveDate.getValue().get(i);
                if (note.getId() != id) {
                    updatedNotes.add(note);
                }
            }
            notesLiveDate.setValue(updatedNotes);
        }

        return isDeleted;
    }

    public boolean editNote(long noteId, String title, String body) {
        NoteModel updatedNote = new NoteModel(noteId, title, body, Utils.getCurrentLocalDate());
        boolean isUpdated = editNoteUseCase.invoke(updatedNote);
        if (isUpdated) {
            List<NoteModel> updatedNotes = notesLiveDate.getValue();
            for(int i = 0; i < updatedNotes.size(); i++) {
                NoteModel note = updatedNotes.get(i);
                if (note.getId() == noteId) {
                    updatedNotes.set(i, updatedNote);
                }
            }
            notesLiveDate.setValue(updatedNotes);
        }
        return isUpdated;
    }
}
