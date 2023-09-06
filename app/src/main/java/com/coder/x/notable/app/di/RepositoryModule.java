package com.coder.x.notable.app.di;

import com.coder.x.notable.data.repository.note.NoteRepositoryImpl;
import com.coder.x.notable.data.source.local.note.NoteLocalDataSource;
import com.coder.x.notable.domain.repository.NoteRepository;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class RepositoryModule {

    @Provides
    NoteRepository provideNoteRepository(NoteLocalDataSource noteLocalDataSource) {
        return new NoteRepositoryImpl(noteLocalDataSource);
    }
}
