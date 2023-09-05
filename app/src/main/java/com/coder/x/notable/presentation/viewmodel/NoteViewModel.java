package com.coder.x.notable.presentation.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.coder.x.notable.data.model.NoteForm;
import com.coder.x.notable.data.model.NoteModel;
import com.coder.x.notable.domain.usecases.note.AddNotesUseCase;
import com.coder.x.notable.domain.usecases.note.ListNotesFromLocalUseCase;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class NoteViewModel extends ViewModel {

    private final String TAG = "NoteViewModel";

    private final AddNotesUseCase addNotesUseCase;

    public MutableLiveData<List<NoteModel>> notesLiveDate = new MutableLiveData<>(new ArrayList<>());


    @Inject
    public NoteViewModel(
            ListNotesFromLocalUseCase listNotesFromLocalUseCase,
            AddNotesUseCase addNotesUseCase
    ) {
        this.addNotesUseCase = addNotesUseCase;
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

    public void deleteNote() {
        Log.d(TAG, "NoteViewModel: Delete Note");
    }

    public void editNote() {
        Log.d(TAG, "NoteViewModel: Edit Note");
    }
}
