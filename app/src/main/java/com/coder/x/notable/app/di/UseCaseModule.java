package com.coder.x.notable.app.di;

import com.coder.x.notable.domain.di.NoteRepository;
import com.coder.x.notable.domain.usecases.note.AddNotesUseCase;
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

}
