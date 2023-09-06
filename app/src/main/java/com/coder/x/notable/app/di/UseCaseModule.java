package com.coder.x.notable.app.di;

import com.coder.x.notable.domain.repository.NoteRepository;
import com.coder.x.notable.domain.usecases.note.AddNotesUseCase;
import com.coder.x.notable.domain.usecases.note.DeleteNoteUseCase;
import com.coder.x.notable.domain.usecases.note.EditNoteUseCase;
import com.coder.x.notable.domain.usecases.note.ListNotesFromLocalUseCase;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class UseCaseModule {

    @Provides
    AddNotesUseCase provideAddNoteUseCase(NoteRepository noteRepository) {
        return new AddNotesUseCase(noteRepository);
    }


    @Provides
    ListNotesFromLocalUseCase provideListNotesFromLocalUseCase(NoteRepository noteRepository) {
        return new ListNotesFromLocalUseCase(noteRepository);
    }

    @Provides
    DeleteNoteUseCase provideDeleteNoteUseCase(NoteRepository noteRepository) {
        return new DeleteNoteUseCase(noteRepository);
    }

    @Provides
    EditNoteUseCase provideEditNoteUseCase(NoteRepository noteRepository) {
        return new EditNoteUseCase(noteRepository);
    }

}
