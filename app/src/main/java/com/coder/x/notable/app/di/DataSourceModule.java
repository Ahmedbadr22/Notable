package com.coder.x.notable.app.di;

import com.coder.x.notable.app.db.DBHelper;
import com.coder.x.notable.data.source.local.note.NoteLocalDataSource;
import com.coder.x.notable.data.source.local.note.NoteLocalDataSourceImpl;


import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class DataSourceModule {

    @Provides
    NoteLocalDataSource provideNoteLocalDataSource(DBHelper dbHelper) {
        return new NoteLocalDataSourceImpl(dbHelper);
    }
}
